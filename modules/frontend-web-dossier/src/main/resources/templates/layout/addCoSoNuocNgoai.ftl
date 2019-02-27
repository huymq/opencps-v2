<v-slide-x-transition>
	
	  <v-layout row wrap class="ml-3" style="background-color: #fff;">
	  <v-flex xs12 sm12 class="pb-2">
	  	<div class="row-header">
	  		<div class="background-triangle-big" v-if="cssxModel.dictItemId"> Sửa đổi cơ sở sản xuất nước ngoài</div>
	  		<div class="background-triangle-big" v-else> Thêm mới cơ sở sản xuất nước ngoài</div>
	  		<div class="layout row wrap header_tools row-blue">

	  		</div>

	  	</div>
	  </v-flex>
	  <v-flex xs12 sm2 class="text-xs-right">
	    <label class="mr-3 my-0" style="padding-top: 15px;">Mã CSSX/Nhà Xưởng</label>
	  </v-flex>
	  <v-flex xs12 sm4>
	  	<v-text-field
	  	:disabled="cssxModel.dictItemId"
	  	v-model="cssxModel.itemCode"
	  	placeholder="Nhập mã CSSX/Nhà xưởng"
	  	clearable
	  	class="py-0"
	  	></v-text-field>
	  </v-flex>
	  <v-flex xs12 sm2 class="text-xs-right">
	    <label class="mr-3 my-0" style="padding-top: 15px;"> Tên CSSX/Nhà Xưởng</label>
	  </v-flex>
	  <v-flex xs12 sm4>
	    <v-text-field
	  	v-model="cssxModel.itemName"
	  	placeholder="Nhập tên CSSX/Nhà xưởng"
	  	clearable
	  	class="py-0 pr-3"
	  	></v-text-field>
	  </v-flex>
	  <v-flex xs12 sm2 class="text-xs-right">
	    <label class="mr-3 my-0" style="padding-top: 15px;">Loại hình</label>
	  </v-flex>
	  <v-flex xs12 sm10>
	  	<v-select
	  	  :items="loaiHinhCSSXItems"
	  	  v-model="loaiHinhCSSX"
	  	  item-text="groupName"
	  	  item-value="groupCode"
	  	  clearable
	  	  class="py-0 pr-3"
	  	></v-select>
	  </v-flex>
	  <v-flex xs12 sm2 class="text-xs-right" v-if="loaiHinhCSSX === 'NHAXUONG'">
	    <label class="mr-3 my-0" style="padding-top: 15px;">CSSX cha</label>
	  </v-flex>
	  <v-flex xs12 sm10 v-if="loaiHinhCSSX === 'NHAXUONG'">
	  	<v-select
	  	  :items="cssxChaItems"
	  	  v-model="cssxModel.parentItemCode"
	  	  item-text="itemName"
	  	  item-value="itemCode"
	  	  clearable
	  	  class="py-0 pr-3"
	  	></v-select>
	  </v-flex>
	  <v-flex xs12 sm2 class="text-xs-right">
	    <label class="mr-3 my-0" style="padding-top: 30px;">Địa chỉ CSSX/Nhà Xưởng</label>
	  </v-flex>
	  <v-flex xs12 sm10>
	  	<v-text-field
	  	multi-line
	  	v-model="cssxModel.itemDescription"
	  	placeholder="Nhập mã CSSX/Nhà xưởng"
	  	clearable
	  	class="py-0 pr-3"
	  	></v-text-field>
	  </v-flex>
	  <v-flex xs12 sm12>
	    <v-expansion-panel expand class="my-0 opencps-dossier-info opencps-dossier-part-style">
		<v-expansion-panel-content class="expansion-header-registration" v-bind:value="true">
		
			<div slot="header" class="text-bold primary--text">Doanh nghiệp nhập khẩu (trong nước) có liên kết</div>
			<v-layout row wrap class="ml-0">
				<v-flex xs12 sm12 v-if="!loadingDoanhNghiepTT_NN">
					<v-data-table 
						:headers="headersDoanhNghiepTT_NN"
						:items="itemsDoanhNghiepTT_NN"
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
							<td class="text-xs-center" style="padding: 8px; width: 3%;">
								{{ props.index + 1 }}
							</td>
							<td style="padding: 8px; width: 33%;" class="text-xs-left">
								{{ props.item.applicantName }}  <br/>
								{{ props.item.address }}
							</td>
							<td style="padding: 8px;" class="text-xs-left">
								{{ props.item.applicantIdNo }} <br/>
								{{ props.item.contactTelNo }} <br/>
								{{ props.item.contactEmail }} 
							</td>
							<td style="padding: 8px;" class="text-xs-left">{{ props.item.contactName }}</td>
							<td style="padding: 8px;" class="text-xs-left">
								{{ props.item['loaiHinh'] }} 
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
	  </v-flex>
	  <v-flex xs12 sm12 class="pb-2">
	    <v-btn color="primary" small @click="saveCoSoNuocNgoai()">Lưu lại</v-btn>
	    <v-btn color="primary" small @click="backCSSXNuocNgoai()">Quay lại</v-btn>
	  </v-flex>
	</v-layout>
</v-slide-x-transition>