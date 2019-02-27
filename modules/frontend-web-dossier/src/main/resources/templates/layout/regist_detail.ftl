<!-- TODO detailTemplate page -->
<div v-if="detailRegistPage" style="width: 100%;">
	<div class="row-header">
		<div class="background-triangle-big"> Thông tin doanh nghiệp trong nước</div>
		<div class="layout row wrap header_tools row-blue">
	
			<div class="flex xs12 text-right" style="margin-left: auto;">
		
				<v-btn flat class=" my-0 py-0 btn-border-left" color="grey darken-1" v-on:click.native="undoDetailRegistPage()">
					<v-icon class="mr-2">undo</v-icon>
				Quay lại
				</v-btn>
                <v-btn v-if="navigationFilterview" v-on:click.native="navigationFilterview = !navigationFilterview" flat icon class="mr-3 my-0 hidden-sm-and-down"><v-icon>fullscreen</v-icon></v-btn>

                <v-btn v-if="!navigationFilterview" v-on:click.native="navigationFilterview = !navigationFilterview" flat icon class="mr-3 my-0 hidden-sm-and-down"><v-icon>fullscreen_exit</v-icon></v-btn>

			</div>
	
		</div>
	
	</div>
	
	<v-expansion-panel expand class="my-0 opencps-dossier-info">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">I. Thông tin chung <i>({{ detailRegistModel.registrationState | registrationState }})</i></div>
		<v-layout wrap class="px-4 pb-2 pt-2">
			<v-flex xs12 sm6>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Tên tổ chức/ Doanh nghiệp (<span style="color: red;">*</span>): 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="applicantName">
						<span v-if="themeDisplay.getUserId() != detailRegistModel.userId">
						
							{{detailRegistModel.applicantName}}
							
						</span>
						<v-text-field v-else
			              v-model="detailRegistModel.applicantName"
			              placeholder="tên tổ chức, doanh nghiệp ..."
			              class="pt-0 mt--5"
			              single-line
			              :rules="[(v) => !!v || 'Tên tổ chức/ Doanh nghiệp bắt buộc phải nhập']"
          				  required
			            ></v-text-field>
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Mã số thuế (<span style="color: red;">*</span>):
					</v-flex>
					<v-flex xs12 sm7 jx-bind="applicantIdNo">
						<span v-if="themeDisplay.getUserId() != detailRegistModel.userId">
						
							{{detailRegistModel.applicantIdNo}}
							
						</span>
						<v-text-field v-else
			              v-model="detailRegistModel.applicantIdNo"
			              placeholder="mã số thuế ..."
			              class="pt-0 mt--5"
			              single-line
			              :rules="[(v) => !!v || 'Mã số thuế bắt buộc phải nhập']"
          				  required
			            ></v-text-field>
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Ngày cấp: 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="applicantIdDate">
						<span v-if="themeDisplay.getUserId() != detailRegistModel.userId">
						
							{{detailRegistModel.applicantIdDate | date}}
							
						</span>
						<v-menu v-else
					        lazy
					        :close-on-content-click="false"
					        v-model="menu"
					        transition="scale-transition"
					        offset-y
					        full-width
					        :nudge-right="40"
					        max-width="290px"
					        min-width="290px"
					      >
					        <v-text-field
					          slot="activator"
					          class="pt-0 mt--5"
					          placeholder="ngày ... tháng ... năm"
					          v-model="detailRegistModel.applicantIdDate"
					          append-icon="event"
					          readonly
					          @blur="detailRegistModel.applicantIdDate = parseDate(dateFormatted)"
					        ></v-text-field>
					        <v-date-picker v-model="detailRegistModel.applicantIdDate" @input="dateFormatted = formatDate($event)" no-title scrollable actions>
					        </v-date-picker>
					      </v-menu>

					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Người đại diện (<span style="color: red;">*</span>): 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="contactName">
						<span v-if="themeDisplay.getUserId() != detailRegistModel.userId">
						
							{{detailRegistModel.contactName}}
							
						</span>
						<v-text-field v-else
			              v-model="detailRegistModel.contactName"
			              placeholder="tên người đại diện ..."
			              class="pt-0 mt--5"
			              single-line
			              :rules="[(v) => !!v || 'Người đại diện bắt buộc phải nhập']"
          				  required
			            ></v-text-field>
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Số điện thoại liên hệ: 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="contactTelNo">
						{{detailRegistModel.contactTelNo}}
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Địa chỉ email liên hệ (<span style="color: red;">*</span>): 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="contactEmail">
						<span v-if="themeDisplay.getUserId() != detailRegistModel.userId">
						
							{{detailRegistModel.contactEmail}}
							
						</span>
						<v-text-field v-else
			              v-model="detailRegistModel.contactEmail"
			              placeholder="địa chỉ email ..."
			              class="pt-0 mt--5"
			              single-line
			              :rules="[(v) => !!v || 'Địa chỉ email bắt buộc phải nhập']"
          				  required
			            ></v-text-field>
					</v-flex>
				</v-layout>
			</v-flex>
			<v-flex xs12 sm6>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Địa chỉ (<span style="color: red;">*</span>): 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="address">
						<span v-if="themeDisplay.getUserId() != detailRegistModel.userId">
						
							{{detailRegistModel.address}}
							
						</span>
						<v-text-field v-else
			              v-model="detailRegistModel.address"
			              placeholder="địa chỉ ..."
			              class="pt-0 mt--5 address--height"
			              multi-line
			              :rules="[(v) => !!v || 'Địa chỉ bắt buộc phải nhập']"
          				  required
			            ></v-text-field>
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Tỉnh/ Thành Phố: 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="cityCode">
						{{detailRegistModel.cityName}}
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Quận/ Huyện: 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="districtCode">
						{{detailRegistModel.districtName}}
					</v-flex>
				</v-layout>
				<v-layout wrap class="pb-2">
					<v-flex xs12 sm5 class="text-right text-bold pr-2">
						Xã/ Phường: 
					</v-flex>
					<v-flex xs12 sm7 jx-bind="wardCode">
						{{detailRegistModel.wardName}}
					</v-flex>
				</v-layout>
				<!-- <v-layout row wrap class="pb-2">
					<v-flex xs12 sm3 class="text-right text-bold pr-2">
						Ánh xạ Oracal
					</v-flex>
					<v-flex xs12 sm9>
						<v-select
						:loading="loadingAnhXaTK"
						:items="itemsAnhXaOracle"
						:rules="[() => select.length > 3 || 'Bạn phải nhập ít nhất 3 ký tự để tìm kiếm!']"
						:search-input.sync="searchAnhXaTK"
						@change="changeAnhXaTK"
						v-model="anhXaOracle"
						item-text="itemName"
						item-value="itemCode"
						autocomplete
						cache-items
						></v-select>
					</v-flex>
				</v-layout> -->
			</v-flex>
		</v-layout>

		</v-expansion-panel-content>
	</v-expansion-panel>

	<v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">II. Thông tin doanh nghiệp và các xưởng lắp ráp (nếu có)</div>
		<v-expansion-panel class="my-0 expansion__list_style">
	        <v-expansion-panel-content v-for="(item,i) in registForms" v-if="item" :key="item.referenceUid">
	        <div slot="header" @click="showAlpacaJSFORMRegist(item)">{{i + 1}}. {{item.formName}}</div>
	
	        <div :id="'regist_form_'+item.referenceUid" class="expansion-panel__header"></div>
	
	        </v-expansion-panel-content>
	    </v-expansion-panel>

		</v-expansion-panel-content>
	</v-expansion-panel>

	<v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">III. Cơ sở sản xuất nước ngoài được liên kết</div>
		<v-layout row wrap class="ml-0">
			<v-flex xs12 sm12 v-if="!loadingCoSoNuocNgoai_Regis">
				<v-data-table 
					:headers="headersCoSoNuocNgoai_Regis"
					:items="itemsCoSoNuocNgoai_Regis"
					no-data-text="Không có dữ liệu"
					hide-actions
					class="table__overflow ml-0 px-3 py-2"
					loading="true"
					hide-actions
				> 
					<template slot="headers" slot-scope="props">
						<tr>
							<th v-for="header in props.headers" :key="header.text"
							:class="['column text-xs-center']" v-html="header.text"
							>
							</th>
						</tr>
					</template>
					<template slot="items" slot-scope="props">
						<td style="padding: 8px 0px 8px 0px; width: 3%; " class="text-xs-center">
							<!-- {{ pageCoSoNuocNgoai * 15 - 15 + props.index + 1 }} -->
							{{ props.index + 1 }}
						</td>
						<td style="padding: 8px;" class="text-xs-center">
							{{props.item.itemCode}}
						</td>
						<td style="padding: 8px; width: 30%;" class="text-xs-center">
							{{props.item.itemName}}
						</td>
						<td style="padding: 8px; width: 40%;" class="text-xs-center">
							{{props.item.itemDescription}}
						</td>
					</template>
				</v-data-table>
		  	</v-flex>
			<v-flex xs12 sm12 class="text-xs-center" v-else>
			    <v-progress-circular indeterminate v-bind:size="70" v-bind:width="2" color="purple"></v-progress-circular>
			</v-flex>
		</v-layout>

		</v-expansion-panel-content>
	</v-expansion-panel>

	<v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">IV. Lịch sử đánh giá COP</div>
		<v-layout row wrap class="ml-0">
			<v-flex xs12 sm12 v-if="!loadingLichSuDanhGiaCOP">
				<v-data-table 
					:headers="headersLichSuDanhGiaCOP"
					:items="itemsLichSuDanhGiaCOP"
					no-data-text="Không có dữ liệu"
					hide-actions
					class="table__overflow ml-0 px-3 py-2"
					loading="true"
					hide-actions
				>
					<template slot="headers" slot-scope="props">
						<tr>
							<th v-for="header in props.headers" :key="header.text"
							:class="['column text-xs-center']" v-html="header.text"
							>
							</th>
						</tr>
					</template>
					<template slot="items" slot-scope="props">
						<td style="padding: 8px 0px 8px 0px; width: 3%; " class="text-xs-center">
							<!-- {{ pageCoSoNuocNgoai * 15 - 15 + props.index + 1 }} -->
							{{ props.index + 1 }}
						</td>
						<td style="padding: 8px;" class="text-xs-center">
							{{props.item.itemCode}}
						</td>
						<td style="padding: 8px; width: 30%;" class="text-xs-center">
							{{props.item.itemName}}
						</td>
						<td style="padding: 8px; width: 40%;" class="text-xs-center">
							{{props.item.itemDescription}}
						</td>
					</template>
				</v-data-table>
		  	</v-flex>
			<v-flex xs12 sm12 class="text-xs-center" v-else>
			    <v-progress-circular indeterminate v-bind:size="70" v-bind:width="2" color="purple"></v-progress-circular>
			</v-flex>
		</v-layout>

		</v-expansion-panel-content>
	</v-expansion-panel>

	<v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">V. Hồ sơ đến hạn xác nhận hiệu lực</div>
		<v-layout row wrap class="ml-0">
			<v-flex xs12 sm12 v-if="!loadingHSDenHanXacNhan">
				<v-data-table 
					:headers="headersHSDenHanXacNhan"
					:items="itemsHSDenHanXacNhan"
					no-data-text="Không có dữ liệu"
					hide-actions
					class="table__overflow ml-0 px-3 py-2"
					loading="true"
					hide-actions
				>
					<template slot="headers" slot-scope="props">
						<tr>
							<th v-for="header in props.headers" :key="header.text"
							:class="['column text-xs-center']" v-html="header.text"
							>
							</th>
						</tr>
					</template>
					<template slot="items" slot-scope="props">
						<td style="padding: 8px; padding-left: 0px; text-align: center;">
							{{ props.index + 1 }}
						</td>
						<td style="padding: 8px;" class="text-xs-left">
							{{ props.item.serviceName }} 
							<br>
							{{ props.item.applicantName }} 
						</td>
						<td style="padding: 8px;" class="text-xs-left">
							{{ props.item.dossierIdCTN }} 
							<br v-if="props.item.dossierNo">
							{{ props.item.dossierNo }} 
						</td>
						<td style="padding: 8px;" class="text-xs-left">
							{{ props.item.submitDate}}
							<br v-if="props.item.submitDate">
							{{ props.item.receiveDate}}
						</td>

						<td style="padding: 8px;" class="text-xs-center">

							<span v-if="props.item.certNo">{{ props.item.certNo }}</span>
							<span v-else>---</span> <br>
							<span v-if="props.item.certDate">{{ props.item.certDate }}</span>
							<span v-else>---</span>
						</td>

						<td style="padding: 8px;" class="text-xs-left" v-html="props.item.briefNote">
						</td>
						<td style="padding: 8px;" class="text-xs-left" v-html="props.item.applicantNote"></td>
					</template>
				</v-data-table>
		  	</v-flex>
			<v-flex xs12 sm12 class="text-xs-center" v-else>
			    <v-progress-circular indeterminate v-bind:size="70" v-bind:width="2" color="purple"></v-progress-circular>
			</v-flex>
		</v-layout>

		</v-expansion-panel-content>
	</v-expansion-panel>

	<v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">VI. Sản phẩm dừng sản xuất</div>
		<v-layout row wrap class="ml-0">
			<v-flex xs12 sm12 v-if="!loadingSpDungSanXuat">
				<v-data-table 
					:headers="headersSpDungSanXuat"
					:items="itemsSpDungSanXuat"
					no-data-text="Không có dữ liệu"
					hide-actions
					class="table__overflow ml-0 px-3 py-2"
					loading="true"
					hide-actions
				>
					<template slot="headers" slot-scope="props">
						<tr>
							<th v-for="header in props.headers" :key="header.text"
							:class="['column text-xs-center']" v-html="header.text"
							>
							</th>
						</tr>
					</template>
					<template slot="items" slot-scope="props">
						<td style="padding: 8px 0px 8px 0px; width: 3%; " class="text-xs-center">
							<!-- {{ pageCoSoNuocNgoai * 15 - 15 + props.index + 1 }} -->
							{{ props.index + 1 }}
						</td>
						<td style="padding: 8px;" class="text-xs-center">
							{{props.item.itemCode}}
						</td>
						<td style="padding: 8px; width: 30%;" class="text-xs-center">
							{{props.item.itemName}}
						</td>
						<td style="padding: 8px; width: 40%;" class="text-xs-center">
							{{props.item.itemDescription}}
						</td>
					</template>
				</v-data-table>
		  	</v-flex>
			<v-flex xs12 sm12 class="text-xs-center" v-else>
			    <v-progress-circular indeterminate v-bind:size="70" v-bind:width="2" color="purple"></v-progress-circular>
			</v-flex>
		</v-layout>

		</v-expansion-panel-content>
	</v-expansion-panel>

	<v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
		<div slot="header" class="text-bold primary--text">VII. Quản lý phương thức cấp phiếu xuất xưởng</div>
		<v-layout row wrap class="ml-0">
			<v-flex xs12 sm12 v-if="!loadingPtCapPhieuXX">
				<v-data-table 
					:headers="headersPtCapPhieuXX"
					:items="itemsPtCapPhieuXX"
					no-data-text="Không có dữ liệu"
					hide-actions
					class="table__overflow ml-0 px-3 py-2"
					loading="true"
					hide-actions
				>
					<template slot="headers" slot-scope="props">
						<tr>
							<th v-for="header in props.headers" :key="header.text"
							:class="['column text-xs-center']" v-html="header.text"
							>
							</th>
						</tr>
					</template>
					<template slot="items" slot-scope="props">
						<td style="padding: 8px 0px 8px 0px; width: 3%; " class="text-xs-center">
							<!-- {{ pageCoSoNuocNgoai * 15 - 15 + props.index + 1 }} -->
							{{ props.index + 1 }}
						</td>
						<td style="padding: 8px;" class="text-xs-center">
							{{props.item.itemCode}}
						</td>
						<td style="padding: 8px; width: 30%;" class="text-xs-center">
							{{props.item.itemName}}
						</td>
						<td style="padding: 8px; width: 40%;" class="text-xs-center">
							{{props.item.itemDescription}}
						</td>
					</template>
				</v-data-table>
				<div class="pl-5 pt-1 pb-2">
					<span style="font-weight: bold;">Ghi chú :</span>
					<p class="pl-4">
						-  5. Sản lượng (số phiếu đã lấy trong 1 năm, hoặc trong vòng n tháng gần nhất, hoặc từ ngày đến ngày). <br>
						-  6. Sản lượng trung bình/ tháng trong 1 năm hoặc 6 tháng gần nhất (chỉ tính những tháng phát sinh). <br>
						-  7. Sản lượng trung bình/ tháng, không tính những tháng đột biến (> 20%, 30%). <br>
						-  8. Tính thời gian COP gần nhất. <br>
						-  9. Ngày kiểm tra đột xuất gần nhất, ngày giám sát gần nhất. <br>
						-  10. Số lần kiểm tra đột xuất không đạt trong vòng 6 tháng hoặc 1 năm gần nhất. <br>
						-  11. Số lần kiểm tra đột xuất, giám sát trong tháng hiện tại. <br>
						-  12. Số lần lấy phiếu trong tháng hiện tại. <br>
						-  13. Ngày đầu tiên trong 1 chu kỳ so với ngày hiện tại. <br>
						-  14. Số lần kiểm tra trong 1 chu kỳ (đếm lùi từ 1 ngày thuộc tham số đầu vào). <br>

					</p>
				</div>
		  	</v-flex>
			<v-flex xs12 sm12 class="text-xs-center" v-else>
			    <v-progress-circular indeterminate v-bind:size="70" v-bind:width="2" color="purple"></v-progress-circular>
			</v-flex>
		</v-layout>

		</v-expansion-panel-content>
	</v-expansion-panel>
	
	<v-btn primary class="ml-0 mr-0" v-on:click.native="detailRegistPage = !detailRegistPage" v-if="themeDisplay.getUserId() == detailRegistModel.userId">
		Ghi lại
	</v-btn>
	<v-btn primary class="ml-0 mr-0" v-on:click.native="registrationPheDuyet(2)" v-else-if="(detailRegistModel.registrationState !== 2 )&& stateButtonregistration">
		<v-icon class="mr-2">done</v-icon>
		Phê duyệt
	</v-btn>
	<v-btn primary class="ml-0 mr-0" v-on:click.native="registrationPheDuyet(3)" v-if="(detailRegistModel.registrationState !== 3 && detailRegistModel.registrationState !== 2) && stateButtonregistration" >
		<v-icon class="mr-2">undo</v-icon>
		Yêu cầu chỉnh sửa đăng kí
	</v-btn>
</div>
