webpackJsonp([9],{292:function(t,e,s){var a=s(42)(s(311),s(322),null,null);t.exports=a.exports},311:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s(44),o=s.n(a),n=s(207);e.default={props:["index"],data:function(){return{keywords:"",selected:[],advanced_filter:!1,statusAll:"new,receiving,processing,waiting,paying,done,expired,cancelled",headers:[{text:"STT",align:"center",sortable:!1,class:"stt_column"},{text:"Mã hồ sơ",align:"center",sortable:!1},{text:"Người đăng ký",align:"center",sortable:!1},{text:"Tên thủ tục",align:"center",sortable:!1},{text:"Địa chỉ",align:"center",sortable:!1},{text:"Ngày giờ hẹn trả",align:"center",sortable:!1},{text:"Thời hạn",align:"center",sortable:!1},{text:"",align:"center",sortable:!1,class:"action_column"}],danhSachHoSoTables:[],itemperpage:15,pages:0,page:1,total:0}},computed:{loadingTable:function(){return this.$store.getters.loadingTable},trangThaiHoSoList:function(){return this.$store.getters.loadtrangThaiHoSoList}},watch:{index:function(t){var e=this;e.$store.dispatch("setCurrentIndex",e.index),e.selected=[],e.keywords="",e.page=1;var s="all"===e.trangThaiHoSoList[t]?e.statusAll:e.trangThaiHoSoList[t].id;console.log(s);var a={keywords:e.keywords,status:"",start:e.page*e.itemperpage-e.itemperpage,end:e.page*e.itemperpage};e.$store.getters.danhSachHoSo(a).then(function(t){e.danhSachHoSoTables=t.data,e.total=t.total,e.pages=Math.ceil(e.total/e.itemperpage)})},page:function(t){var e=this;e.page=t,e.loadDataTable()}},created:function(){var t=this;t.page=1,t.$nextTick(function(){t.$store.dispatch("setCurrentIndex",t.index),t.loadDataTable()})},methods:{checkAction:function(t){return"new"===t?"print,send,delete":"releasing"===t?"result,ticket":"done"===t?"view,ticket":"waiting"===t?"view,ticket":"receiving"===t?"view,ticket":"correcting"===t?"view,ticket":"processing"===t?"view,ticket":void 0},checkPrint:function(t,e){return!t.applicantName&&!t.address},showMultiDelete:function(t){return"new"===t},keywordSearch:function(){var t=this;t.page=1,t.loadDataTable()},loadDataTable:function(){var t=this;console.log(t.trangThaiHoSoList[t.index].id);var e="all"===t.trangThaiHoSoList[t.index].id?t.statusAll:t.trangThaiHoSoList[t.index];console.log(e);var s={keywords:t.keywords,status:"",start:t.page*t.itemperpage-t.itemperpage,end:t.page*t.itemperpage};t.$store.getters.danhSachHoSo(s).then(function(e){t.danhSachHoSoTables=e.data,t.total=e.total,t.pages=Math.ceil(t.total/t.itemperpage)})},chuyenXuLy:function(t){var e=this,s={dossierId:t.dossierId,actionCode:1e4};e.$root.$confirm.open("Thông báo","Bạn chắc chắn muốn thực hiện thao tác này?",{color:"blue darken-4"}).then(function(t){e.$store.dispatch("postAction",s).then(function(t){n.b("success","Xử lý thành công"),e.loadDataTable()}).catch(function(t){n.b("error","Xử lý thất bại")})}).catch(function(t){console.log("kkk")})},traKetQua:function(t){var e=this,s={dossierId:t.dossierId,actionCode:3e4};e.$root.$confirm.open("Thông báo","Bạn chắc chắn muốn thực hiện thao tác này?",{color:"blue darken-4"}).then(function(t){e.$store.dispatch("postAction",s).then(function(t){n.b("success","Xử lý thành công"),e.loadDataTable()}).catch(function(t){n.b("error","Xử lý thất bại")})}).catch(function(t){console.log("kkk")})},moveProcess:function(){var t=this;t.$root.$confirm.open("Thông báo","Bạn chắc chắn muốn thực hiện thao tác này?",{color:"blue darken-4"}).then(function(e){for(var s=[],a=0;a<t.selected.length;a++)if(!t.selected[a].applicantName&&!t.selected[a].address)return void t.$root.$confirm.open("Thông báo","Bạn phải điền đầy đủ thông tin của hồ sơ trước khi thực hiện thao tác này?",{color:"blue darken-4"}).then(function(t){}).catch(function(t){});if(t.selected.forEach(function(e){var a={dossierId:e.dossierId,actionCode:1e4};s.push(t.$store.dispatch("postAction",a))}),0===s.length)return void n.b("error","Bạn chưa chọn hồ sơ nào");o.a.all(s).then(function(e){n.b("success","Xử lý thành công"),t.loadDataTable()}).catch(function(t){n.b("error","Xử lý thất bại")})}).catch(function(t){console.log("kkk")}),console.log(t.selected)},moveRelease:function(){var t=this;t.$root.$confirm.open("Thông báo","Bạn chắc chắn muốn thực hiện thao tác này?",{color:"blue darken-4"}).then(function(e){for(var s=[],a=0;a<t.selected.length;a++)if(!t.selected[a].applicantName&&!t.selected[a].address)return void t.$root.$confirm.open("Thông báo","Bạn phải điền đầy đủ thông tin của hồ sơ trước khi thực hiện thao tác này?",{color:"blue darken-4"}).then(function(t){}).catch(function(t){});if(t.selected.forEach(function(e){var a={dossierId:e.dossierId,actionCode:3e4};s.push(t.$store.dispatch("postAction",a))}),0===s.length)return void n.b("error","Bạn chưa chọn hồ sơ nào");o.a.all(s).then(function(e){n.b("success","Xử lý thành công"),t.loadDataTable()}).catch(function(t){n.b("error","Xử lý thất bại")})}).catch(function(t){console.log("kkk")}),console.log(t.selected)},deleteDosier:function(t,e){var s=this;s.$root.$confirm.open("Xóa","Bạn có muốn xoá hồ sơ này?",{color:"red"}).then(function(a){if(t){s.$store.dispatch("deleteDossier",t).then(function(t){s.danhSachHoSoTables.splice(e,1)})}}).catch(function(t){console.log("kkk")}),console.log(s.selected)},moveDelete:function(){var t=this;t.$root.$confirm.open("Xóa","Bạn có chắc chắn muốn xoá các mục đã chọn?",{color:"red"}).then(function(e){var s=[];if(t.selected.forEach(function(e){s.push(t.$store.dispatch("deleteDossier",e.dossierId))}),0===s.length)return void n.b("error","Bạn chưa chọn hồ sơ nào");o.a.all(s).then(function(e){t.selected&&t.selected.forEach(function(e){t.danhSachHoSoTables.splice(t.danhSachHoSoTables.findIndex(function(t){return e.dossierId===t.dossierId}),1)}),n.b("success","Xử lý thành công")}).catch(function(t){n.b("error","Xử lý thất bại")})}).catch(function(t){}),console.log(t.selected)},toDetailDossier:function(t,e){var s="/group/cong-xu-ly/mot-cua-dien-tu#/danh-sach-ho-so/"+t+"/tiep-nhan-ho-so/"+e;window.location.href=s},toDetailPhieuHen:function(t,e){var s=this;s.$store.commit("setPrintPH",!0),console.log(s.$store.getters.printPH);var a="/group/cong-xu-ly/mot-cua-dien-tu#/danh-sach-ho-so/"+t+"/tiep-nhan-ho-so/"+e+"/phieu-hen";window.open(a,"_blank")},durationText:function(t,e){var s;if(1===e&&t>8){var a=Math.floor(t/8)+" ngày",o=void 0;o=t%8!=0?8*(t/8-Math.floor(t/8))+" giờ":"",s=a+" "+o}else 0===e?s=t+" ngày":1===e&&t<=8&&(s=t+" giờ");return s}},filters:{processUnit:function(t){return 1===t?"giờ":0===t?"ngày":void 0}}}},322:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[t.loadingTable?s("content-placeholders",{staticClass:"mt-3"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("div",{staticClass:"row-header",staticStyle:{"margin-top":"6px"}},[s("div",{staticClass:"background-triangle-big"},[t.trangThaiHoSoList?s("span",[t._v(t._s(t.trangThaiHoSoList[t.index].title))]):t._e()]),t._v(" "),s("div",{staticClass:"layout row wrap header_tools row-blue"},[s("div",{staticClass:"flex text-ellipsis"},[s("v-text-field",{attrs:{placeholder:"Nhập từ khoá ...","prepend-icon":"search",solo:""},nativeOn:{change:function(e){return t.keywordSearch(e)}},model:{value:t.keywords,callback:function(e){t.keywords=e},expression:"keywords"}})],1),t._v(" "),s("div",{staticClass:"flex text-right",staticStyle:{"margin-left":"auto"}})])]),t._v(" "),s("v-slide-y-transition",[t.advanced_filter?s("div",{staticClass:"panel",staticStyle:{height:"auto",width:"100%",margin:"0","border-radius":"0","border-top":"1px solid white","background-color":"#e1e2e1",padding:"15px"}},[s("div",{staticClass:"layout wrap"},[s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1),t._v(" "),s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1),t._v(" "),s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1),t._v(" "),s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1)],1),t._v(" "),s("div",{staticClass:"layout wrap"},[s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1),t._v(" "),s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1),t._v(" "),s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1),t._v(" "),s("v-flex",{staticClass:"pr-4 no-wrap",attrs:{xs12:"",sm3:""}},[t.loadingTable?s("content-placeholders",{staticClass:"mt-1"},[s("content-placeholders-text",{attrs:{lines:1}})],1):s("v-text-field")],1)],1),t._v(" "),s("v-layout",{attrs:{wrap:""}},[s("v-flex",{attrs:{xs12:"",sm12:""}},[s("v-btn",{staticClass:"mx-0 my-0 mt-2",attrs:{color:"primary"}},[s("v-icon",{attrs:{size:"16"}},[t._v("search")]),t._v("\n            Tìm kiếm\n          ")],1),t._v(" "),s("v-btn",{staticClass:"mx-0 my-0 mt-2",attrs:{color:"primary"}},[s("v-icon",{attrs:{size:"16"}},[t._v("delete")]),t._v("\n            Xóa lọc\n          ")],1)],1)],1)],1):t._e()]),t._v(" "),t.loadingTable?s("content-placeholders",[s("content-placeholders-img"),t._v(" "),s("content-placeholders-heading")],1):s("div",[s("v-data-table",{staticClass:"table-landing table-bordered",attrs:{headers:t.headers,items:t.danhSachHoSoTables,"total-items":t.total,"item-key":"dossierId","select-all":"","hide-actions":"","no-data-text":"Không tìm thấy "+t.trangThaiHoSoList[t.index].title,"no-results-text":"Không tìm thấy "+t.trangThaiHoSoList[t.index].title},scopedSlots:t._u([{key:"headerCell",fn:function(e){return[s("v-tooltip",{attrs:{bottom:""}},[s("span",{attrs:{slot:"activator"},slot:"activator"},[t._v("\n            "+t._s(e.header.text)+"\n          ")]),t._v(" "),s("span",[t._v("\n            "+t._s(e.header.text)+"\n          ")])])]}},{key:"items",fn:function(e){return[s("td",[s("v-checkbox",{attrs:{primary:"","hide-details":""},model:{value:e.selected,callback:function(s){t.$set(e,"selected",s)},expression:"props.selected"}})],1),t._v(" "),s("td",{staticClass:"text-xs-center stt_column"},[t._v(t._s(e.index+1))]),t._v(" "),s("td",{staticClass:"text-xs-left"},[t._v(t._s(e.item.dossierIdCTN))]),t._v(" "),s("td",{staticClass:"text-xs-left"},[t._v(t._s(e.item.applicantName))]),t._v(" "),s("td",{staticClass:"text-xs-left"},[s("a",{attrs:{title:"Chi tiết hồ sơ",href:"/group/cong-xu-ly/mot-cua-dien-tu#/danh-sach-ho-so/"+t.index+"/tiep-nhan-ho-so/"+e.item.dossierId}},[s("span",[t._v(t._s(e.item.serviceName))])])]),t._v(" "),s("td",{staticClass:"text-xs-left"},[t._v(t._s(e.item.address))]),t._v(" "),s("td",{staticClass:"text-xs-left"},[t._v(t._s(e.item.dueDate))]),t._v(" "),s("td",{staticClass:"text-xs-left"},[t._v(t._s(t.durationText(e.item.processBlock,e.item.processUnit))+" "),e.item.processBlock?s("span",[t._v("làm việc")]):t._e()]),t._v(" "),s("td",{staticClass:"text-xs-left px-0"},[s("v-tooltip",{attrs:{top:""}},[s("v-btn",{staticClass:"mx-0 my-0",staticStyle:{width:"30px",height:"30px"},attrs:{slot:"activator",icon:""},on:{click:function(s){t.toDetailDossier(t.index,e.item.dossierId)}},slot:"activator"},[s("v-icon",{staticClass:"mx-0",staticStyle:{color:"#1976d2"},attrs:{size:"16"}},[t._v("visibility")])],1),t._v(" "),s("span",[t._v("Xem hồ sơ")])],1),t._v(" "),t.checkAction(e.item.dossierStatus).includes("send")?s("v-tooltip",{attrs:{top:""}},[s("v-btn",{staticClass:"mx-0 my-0",staticStyle:{width:"30px",height:"30px"},attrs:{slot:"activator",icon:"",disabled:t.checkPrint(e.item)},on:{click:function(s){t.toDetailPhieuHen(t.index,e.item.dossierId)}},slot:"activator"},[s("v-icon",{staticClass:"mx-0",staticStyle:{color:"#1976d2"},attrs:{size:"16"}},[t._v("print")])],1),t._v(" "),s("span",[t._v("In phiếu hẹn")])],1):t._e(),t._v(" "),t.checkAction(e.item.dossierStatus).includes("send")?s("v-tooltip",{attrs:{top:""}},[s("v-btn",{staticClass:"mx-0 my-0",staticStyle:{width:"30px",height:"30px"},attrs:{slot:"activator",icon:"",disabled:t.checkPrint(e.item)},on:{click:function(s){t.chuyenXuLy(e.item)}},slot:"activator"},[s("v-icon",{staticClass:"mx-0",staticStyle:{color:"#1976d2"},attrs:{size:"16"}},[t._v("send")])],1),t._v(" "),s("span",[t._v("Chuyển hồ sơ vào xử lý")])],1):t._e(),t._v(" "),t.checkAction(e.item.dossierStatus).includes("ticket")?s("v-tooltip",{attrs:{top:""}},[s("v-btn",{staticClass:"mx-0 my-0",staticStyle:{width:"30px",height:"30px"},attrs:{slot:"activator",icon:""},slot:"activator"},[s("v-icon",{staticClass:"mx-0",staticStyle:{color:"#1976d2"},attrs:{size:"16"}},[t._v("description")])],1),t._v(" "),s("span",[t._v("Phiếu kiểm soát")])],1):t._e(),t._v(" "),t.checkAction(e.item.dossierStatus).includes("result")?s("v-tooltip",{attrs:{top:""}},[s("v-btn",{staticClass:"mx-0 my-0",staticStyle:{width:"30px",height:"30px"},attrs:{slot:"activator",icon:"",to:"/danh-sach-ho-so/"+t.index+"/tiep-nhan-ho-so/"+e.item.dossierId},slot:"activator"},[s("v-icon",{staticClass:"mx-0",staticStyle:{color:"#1976d2"},attrs:{size:"16"}},[t._v("send")])],1),t._v(" "),s("span",[t._v("Trả kết quả")])],1):t._e(),t._v(" "),t.checkAction(e.item.dossierStatus).includes("delete")?s("v-tooltip",{attrs:{top:""}},[s("v-btn",{staticClass:"mx-0 my-0",staticStyle:{width:"30px",height:"30px"},attrs:{slot:"activator",icon:""},on:{click:function(s){t.deleteDosier(e.item.dossierId,e.index)}},slot:"activator"},[s("v-icon",{staticClass:"mx-0",attrs:{size:"16",color:"red darken-3"}},[t._v("delete")])],1),t._v(" "),s("span",[t._v("Xoá")])],1):t._e()],1)]}}]),model:{value:t.selected,callback:function(e){t.selected=e},expression:"selected"}}),t._v(" "),s("div",{staticClass:"mt-3 text-xs-right table-footer"},[s("div",{staticClass:"left"}),t._v(" "),s("span",{staticClass:"mr-2"},[s("i",[t._v("Tổng số "),s("span",{staticClass:"red--text"},[t._v(t._s(t.total))]),t._v(" kết quả được tìm thấy")])]),t._v(" "),s("v-pagination",{attrs:{length:t.pages},model:{value:t.page,callback:function(e){t.page=e},expression:"page"}})],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=9.042c04d736cfbaebcc3e.js.map