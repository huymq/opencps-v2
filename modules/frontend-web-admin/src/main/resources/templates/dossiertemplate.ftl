<#if (Request)??>
	<#include "init.ftl">
</#if>
<div class="row">
   <div class="col-xs-12 col-sm-3 panel P0">
   		<div class="panel-body">
				<div class="row">
          <div class="col-xs-12 col-sm-12">
            <button id="btn_add_dossier_template" class="k-button btn-primary form-control" title="Thêm mẫu hồ sơ"><i class="glyphicon glyphicon-plus"></i> Thêm mẫu hồ sơ </button>
          </div>
        </div>
   			<div class="row MT10">
   			  <div class="col-xs-12 col-sm-12">
            <div class="input-group">
       			  	<input type="text" class="form-control" id="input_search_dossier_template" placeholder="Số hồ sơ, Tên hồ sơ" title="Nhập Sô hồ sơ hoặc Tên hồ sơ để tìm kiếm">
       			  	<div class="input-group-addon btn-primary" id="btn_search_dossier_template" title="Tìm kiếm"><i class="fa fa-search" aria-hidden="true"></i></div>
       			</div>
   			  </div>
   			</div>
   		</div>
   		<div class="col-xs-12 col-sm-12">
   			<ul id ="dossier_template_list_view" class="ul-with-border ul-with-border-style-2"></ul>
   			<div id="dossier_template_pager" class="k-pager-wrap"></div>
   		</div>

      <script type="text/x-kendo-template" id="dossier_template_template">
         <li class="clearfix" data-pk="#: id #" style="padding: 10px 0 10px 5px;" role="option" aria-selected="true">
           <div class="PL0 dossier-template-item" data-pk="#: id #">
              <strong>#: templateNo #</strong>
							<a class="btn-group k-delete-button pull-right" href="\\#" title="Xóa">
									<i aria-hidden="true" class="fa fa-trash"></i>
							</a>
           </div>
           <div class="PL0">
              <div class="edit-buttons">
                <span class="btn-block">#: templateName #</span>
              </div>
           </div>
         </li>
      </script>
   	</div>

    <div class="col-xs-12 col-sm-9">
			<div class="panel panel-body">
				<#include "dossiertemplate_detail.ftl">
			</div>
    </div>
</div>

<script type="text/javascript">
  (function($){
    var dossierTemplateDataSource = new kendo.data.DataSource({
       transport: {
          read: function(options) {
             $.ajax({
                url: "${api.server}" + "/dossiertemplates",
                type: "GET",
                dataType: "json",
								headers: {"groupId": ${groupId}},
                data: {
                  keywords: options.data.keywords,
                  page: options.data.page,
                  pageSize: options.data.pageSize
                },
                success: function(result) {
                  options.success(result);
                },
                error: function(result) {
                  options.error(result);
                  notification.show({
                    message: "Xẩy ra lỗi, vui lòng thử lại"
                  }, "error");
                }
             });
          },
          create: function(options) {
             $.ajax({
                url: "${api.server}" + "/dossiertemplates",
                type: "POST",
                dataType: "json",
								headers: {"groupId": ${groupId}},
                data: {
                  templateNo: options.data.templateNo,
                  templateName: options.data.templateName,
                  description: options.data.description
                },
                success: function(result) {
                  options.success(result);
                  notification.show({
                    message: "Yêu cầu được thực hiện thành công"
                  }, "success");
                },
                error: function(result) {
                  options.error(result);
                  notification.show({
                    message: "Xẩy ra lỗi, vui lòng thử lại"
                  }, "error");
                }
             });
          },
          update: function(options) {
             $.ajax({
                url: "${api.server}" + "/dossiertemplates/" + options.data.dossierTemplateId,
                type: "PUT",
                dataType: "json",
								headers: {"groupId": ${groupId}},
                data: {
                  dossierTemplateId: options.data.dossierTemplateId,
                  templateNo: options.data.templateNo,
                  templateName: options.data.templateName,
                  description: options.data.description
                },
                success: function(result) {
                  options.success(result);
                  notification.show({
                    message: "Yêu cầu được thực hiện thành công"
                  }, "success");
                },
                error: function(result) {
                  options.error(result);
                  fileTemplateDataSource.cancelChanges();
                  notification.show({
                    message: "Xẩy ra lỗi, vui lòng thử lại"
                  }, "error");
                }
             });
          },
          destroy: function(options) {
             $.ajax({
                url: "${api.server}" + "/dossiertemplates/" + options.data.dossierTemplateId,
                type: "DELETE",
                dataType: "json",
								headers: {"groupId": ${groupId}},
                success: function(result) {
                  options.success(result);
                  notification.show({
                    message: "Yêu cầu được thực hiện thành công"
                  }, "success");
                },
                error: function(result) {
                  options.error(result);
                  notification.show({
                    message: "Xẩy ra lỗi, vui lòng thử lại"
                  }, "error");
                }
             });
          },
          parameterMap: function(options, operation) {
             if (operation !== "read" && options.models) {
                return {
                   models: kendo.stringify(options.models)
                };
             }
          },
       },
       error: function(e){
         this.cancelChanges();
       },
       schema: {
          total: "total",
          data: "data",
          model : { id: "dossierTemplateId" },
       },
       pageSize: 10,
       serverPaging: false,
       serverSorting: false,
       serverFiltering: false
    });

    $("#dossier_template_list_view").kendoListView({
       dataSource: dossierTemplateDataSource,
       template: kendo.template($("#dossier_template_template").html()),
       selectable: true,
       dataBound: function(e) {
         var listView = e.sender;
         var firstItem = listView.element.children().first();
         listView.select(firstItem);

        //  the first select dossier template
         onSelectDossiertemplate(firstItem.attr("data-pk"));
				 $("#btn_save_dossier_template").attr("data-pk", firstItem.attr("data-pk"));
       },
       remove: function(e) {
          if(!confirm("Xác nhận xóa mẫu hồ sơ: " + e.model.get("templateName") + "?")){
             e.preventDefault();
          }
       },
			 change: function() {
					var index = this.select().index();
					var dataItem = this.dataSource.view()[index];

					var viewModel = kendo.observable({
							templateNo : dataItem.templateNo,
							templateName : dataItem.templateName,
							description : dataItem.description
					});

					kendo.bind($("#ttmhs"), viewModel);

					$("#btn_save_dossier_template").attr("data-pk", dataItem.id);
				}
    });

    $(document).on("click", ".dossier-template-item", function(event){
      onSelectDossiertemplate($(this).attr("data-pk"));
    });

    var onSelectDossiertemplate = function(id){
      $("#dossier_template_part_listview").getKendoListView().dataSource.read({
        dossierTemplateId: id
      });
    }

    $("#dossier_template_pager").kendoPager({
       dataSource: dossierTemplateDataSource,
       buttonCount: 2,
			 messages: {
        display: "{0}-{1} : {2}"
      }
    });

    $("#input_search_dossier_template").keyup(function(e){
       dossierTemplateFilter();
    });

    $("#btn_search_dossier_template").click(function(){
       dossierTemplateFilter();
    });

    var dossierTemplateFilter = function(){
       var inputSearch = $("#input_search_dossier_template").val();

       var filters = [];
       var filter = {};

       filters.push({field: "templateNo", operator: "contains", value: inputSearch});
       filters.push({field: "templateName", operator: "contains", value: inputSearch});

       filter = {
          logic: "or",
          filters: filters
       };

       dossierTemplateDataSource.filter(filter);
    };

    $(document).on("click", ".btn-edit-dossier-template", function(event){
       event.preventDefault();
       formControl($(this).attr("data-pk"));
    });

    $(document).on("click", "#btn_add_dossier_template", function(event){
       event.preventDefault();
			 var viewModel = kendo.observable({
					 templateNo : "",
					 templateName : "",
					 description : ""
			 });

			 kendo.bind($("#ttmhs"), viewModel);

			 $("#btn_save_dossier_template").attr("data-pk", "");
    });

		$(document).on("click", "#btn_save_dossier_template", function(event){
       event.preventDefault();
			 var dataPk = $(this).attr("data-pk");
			 if (dataPk){
				 updateDossiertemplate(dataPk);
			 } else {
				 addDossierTemplete();
			 }
    });

    var updateDossiertemplate = function(dataPk){
       var dossierTemplate = dossierTemplateDataSource.get(dataPk);

       dossierTemplate.set("templateNo", $("#templateNo").val());
       dossierTemplate.set("templateName", $("#templateName").val());
       dossierTemplate.set("description", $("#description").val());

       dossierTemplateDataSource.sync();
    }

    var addDossierTemplete = function(){
       dossierTemplateDataSource.add({
          "templateNo": $("#templateNo").val(),
          "templateName": $("#templateName").val(),
          "description": $("#description").val(),
       });
       dossierTemplateDataSource.sync();
    };

  })(jQuery);
</script>
