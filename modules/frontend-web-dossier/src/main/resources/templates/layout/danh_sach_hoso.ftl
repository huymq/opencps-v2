<v-slide-x-transition>

<div class="row-header flex-break" v-if="!detailPage">

    <div class="background-triangle-big"> <v-icon flat fab color="white" class="setting_action_all">settings</v-icon> {{hoso_title_table}} </div>

    <div class="layout row wrap header_tools w-100-xs">

        <div class="flex w-100-xs" jx-bind="keywordsSearchDanhSachHoSo"></div>

        <v-btn v-if="navigationFilterview" v-on:click.native="navigationFilterview = !navigationFilterview" flat icon class="mr-4 hidden-sm-and-down"><v-icon>fullscreen</v-icon></v-btn>

        <v-btn v-if="!navigationFilterview" v-on:click.native="navigationFilterview = !navigationFilterview" flat icon class="mr-4 hidden-sm-and-down"><v-icon>fullscreen_exit</v-icon></v-btn>
		
		<v-btn flat v-if="stageFilterView === 'tat_ca_hoso'" class=" my-0 py-0 btn-border-left" color="grey darken-1" v-on:click.native="advanceFilterAll()">
			<v-icon class="mr-2" v-if="!advanced_filter_all">keyboard_arrow_down</v-icon>
			<v-icon class="mr-2" v-else>keyboard_arrow_up</v-icon>
			Nâng cao
		</v-btn>
    </div>

</div>

</v-slide-x-transition>

<v-slide-y-transition>
	<div v-if="advanced_filter_all && stageFilterView === 'tat_ca_hoso'" class="panel" style="height: auto;width: 100%;margin: 0;border-radius: 0;border-top: 1px solid white;background-color: #ffff;padding: 15px;">
		<div class="layout wrap">
			<v-flex xs12 sm2 class="text-xs-right">
				<label class="my-0" style="padding-top: 6px;">Đối tượng</label> <span class="mr-3" style="color: red;">(*)</span>
			</v-flex>
			<v-flex xs12 sm5>
				<v-select
				item-text="itemName"
				item-value="itemCode"
				:items="tcDoiTuongItems"
				clearable
				v-model="tcDoiTuongHS"
				class="py-0"
				@change="changeDoiTuongHS"
				></v-select>
			</v-flex>
			<v-flex xs12 sm2 class="text-xs-right">
				<label class="mr-3 my-0" style="padding-top: 6px;">Phương tiện SXLR</label>
			</v-flex>
			<v-flex xs12 sm3 class="pr-3">
				<v-select
				item-text="itemName"
				clearable
				item-value="itemCode"
				:items="tcPphuongTienItems"
				v-model="tcPhuongTienHS"
				class="py-0"
				></v-select>
			</v-flex>
			<!-- ---------------------- -->
			<v-flex xs12 sm2 class="text-xs-right">
				<label class="mr-3 my-0" style="padding-top: 6px;">Số hồ sơ</label>
			</v-flex>
			<v-flex xs12 sm2>
				<v-text-field
				v-model="tcSoHoSoHS"
				placeholder="Nhập mã số hồ sơ"
				clearable
				class="py-0"
				></v-text-field>
			</v-flex>
			<v-flex xs12 sm2 class="text-xs-right">
				<label class="mr-3 my-0" style="padding-top: 6px;">Ngày nộp</label>
			</v-flex>
			<v-flex xs12 sm2 class="pr-3">
				<v-menu
				ref="menuNN"
				:close-on-content-click="false"
				v-model="menuTcNgayNopHS"
				:nudge-right="40"
				:return-value.sync="date"
				lazy
				transition="scale-transition"
				offset-y
				full-width
				min-width="290px"
				>
				<v-text-field
				slot="activator"
				v-model="tcNgayNopHS"
				placeholder="Từ ngày"
				clearable
				class="py-0"
				readonly
				></v-text-field>
				<v-date-picker v-model="dateTcNgayNopHS" @input="parseTcNgayNopHS()"></v-date-picker>
			</v-menu>
		</v-flex>
		<v-flex xs12 sm2 class="pr-3">
			<v-menu
			ref="menuNN"
			:close-on-content-click="false"
			v-model="menuTcNgayNopDenNgayHS"
			:nudge-right="40"
			:return-value.sync="date"
			lazy
			transition="scale-transition"
			offset-y
			full-width
			min-width="290px"
			>
			<v-text-field
			slot="activator"
			v-model="tcNgayNopDenNgayHS"
			placeholder="Đến ngày"
			clearable
			class="py-0"
			readonly
			></v-text-field>
			<v-date-picker v-model="dateTcNgayNopDenNgayHS" @input="parseTcNgayNopDenNgayHS()"></v-date-picker>
		</v-menu>
	</v-flex>
	<v-flex xs12 sm2 class="pr-3">
		<v-select
		:items="tcNamItems"
		placeholder="Năm"
		v-model="tcNamHS1"
		clearable
		class="py-0"
		></v-select>
	</v-flex>

  <!-- ----------------------------- -->
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Số ĐKKT</label>
		  </v-flex>
		  <v-flex xs12 sm2>
		    <v-text-field
		      v-model="tcSoDKKTHS"
		      placeholder="Nhập số đăng ký kiểm tra"
		      clearable
		      class="py-0"
		    ></v-text-field>
		  </v-flex>
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Ngày cấp ĐKKT</label>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNNHS"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayCapDKKTTuNgayHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayCapDKKTTuNgayHS"
			  	clearable
			  	placeholder="Từ ngày"
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayCapDKKTTuNgayHS" @input="parseTcNgayCapDKKTTuNgayHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNNHS"
			  	:close-on-content-click="false"
			  	v-model="menuTcNGayKTDenNGayHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNGayKTDenNGayHS"
			  	clearable
			  	placeholder="Đến ngày"
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNGayKTDenNGayHS" @input="parseTcNGayKTDenNGayHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-select
		      :items="tcNamItems"
		      placeholder="Năm"
		      v-model="tcNamHS2"
		      clearable
		      class="py-0"
		    ></v-select>
		  </v-flex>
		  <!-- -------------------------------- -->
		  
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Số biên bản KT</label>
		  </v-flex>
		  <v-flex xs12 sm2>
		    <v-text-field
		      v-model="tcSoBBKiemTraHS"
		      placeholder="Nhập số biên bản kiểm tra"
		      clearable
		      class="py-0"
		    ></v-text-field>
		  </v-flex>
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Ngày kiểm tra</label>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
			  	<v-menu
			  	ref="menuNN"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayKTHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayKTHS"
			  	placeholder="Từ ngày"
			  	clearable
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayKTHS" @input="parseNgayKTHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNNHS"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayKTDenNgayHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayKTDenNgayHS"
			  	placeholder="Đến ngày"
			  	clearable
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayKTDenNgayHS" @input="parseNgayKTDenNgayHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-select
		      :items="tcNamItems"
		      placeholder="Năm"
		      v-model="tcNamHS3"
		      clearable
		      class="py-0"
		    ></v-select>
		  </v-flex>
		  <!-- ---------------------------------- -->
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Số chứng chỉ</label>
		  </v-flex>
		  <v-flex xs12 sm2>
		    <v-text-field
		      v-model="tcSoChungChiHS"
		      placeholder="Nhập số chứng chỉ"
		      class="py-0"
		      clearable
		    ></v-text-field>
		  </v-flex>
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Ngày cấp CC</label>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNNHS"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayCapCCHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayCapCCHS"
			  	clearable
			  	placeholder="Từ ngày"
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayCapCCHS" @input="parseNgayCapCCHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNN"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayCapCcDEnNgayHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayCapCcDEnNgayHS"
			  	placeholder="Từ ngày"
			  	clearable
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayCapCcDEnNgayHS" @input="parseNgayCapCcDEnNgayHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-select
		      :items="tcNamItems"
		      placeholder="Năm"
		      v-model="tcNamHS4"
		      clearable
		      class="py-0"
		    ></v-select>
		  </v-flex>
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Số tờ khai HQ</label>
		  </v-flex>
		  <!-- ------------------------------- -->
		  <v-flex xs12 sm2>
		    <v-text-field
		      class="py-0"
		      clearable
		      v-model="tcSoToKhaiHS"
		      placeholder="Nhập số tờ khai hải quan"
		    ></v-text-field>
		  </v-flex>
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Ngày tờ khai HQ</label>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNNHS"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayToKhaiHQHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayToKhaiHQHS"
			  	clearable
			  	placeholder="Từ ngày"
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayToKhaiHQHS" @input="parseNgayToKhaiHQHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-menu
			  	ref="menuNNHS"
			  	:close-on-content-click="false"
			  	v-model="menuTcNgayToKhaiHqDenNgayHS"
			  	:nudge-right="40"
			  	:return-value.sync="date"
			  	lazy
			  	transition="scale-transition"
			  	offset-y
			  	full-width
			  	min-width="290px"
			  	>
			  	<v-text-field
			  	slot="activator"
			  	v-model="tcNgayToKhaiHqDenNgayHS"
			  	placeholder="Đến ngày"
			  	clearable
			  	class="py-0"
			  	readonly
			  	></v-text-field>
			  	<v-date-picker v-model="dateTcNgayToKhaiHqDenNgayHS" @input="parseNgayToKhaiHqDenNgayHS()"></v-date-picker>
			  </v-menu>
		  </v-flex>
		  <v-flex xs12 sm2 class="pr-3">
		    <v-select
		      :items="tcNamItems"
		      placeholder="Năm"
		      clearable
		      v-model="tcNamHS5"
		      class="py-0"
		    ></v-select>
		  </v-flex>
		  
		  <v-flex xs12 sm2 class="text-xs-right">
		  	<label class="mr-3 my-0" style="padding-top: 6px;">Tình trạng CC</label>
		  </v-flex>
		  <v-flex xs12 sm2>
		  	<v-select
		  	item-text="itemName"
		  	item-value="itemCode"
		  	clearable
		  	:items="tcTinhTrangItems"
		  	placeholder="------Lựa chọn--------"
		  	v-model="tcTinhTrangHS"
		  	class="py-0"
		  	></v-select>
		  </v-flex>
		  <v-flex xs12 sm2 class="text-xs-right">
		    <label class="mr-3 my-0" style="padding-top: 6px;">Số phiếu</label>
		  </v-flex>
		  <v-flex xs12 sm2>
		    <v-text-field
		      class="py-0 pr-3"
		      clearable
		      v-model="tcSoSerialHS"
		      placeholder="Nhập số serial"
		    ></v-text-field>
		  </v-flex>
		  <v-flex xs12 sm2>
		    <v-text-field
		      class="py-0 pr-3"
		      clearable
		      v-model="tcTuSoHS"
		      placeholder="Từ số"
		    ></v-text-field>
		  </v-flex>
		  <v-flex xs12 sm2>
		    <v-text-field
		      class="py-0 pr-3"
		      clearable
		      v-model="tcDenSoHS"
		      placeholder="Đến số"
		    ></v-text-field>
		  </v-flex>

		  <v-flex xs12 sm12>
		  	<v-layout row wrap class="mx-0 px-0 mt-3" style="height: 180px; overflow: auto;">
		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Địa điểm ĐKKT</label>
		  		</v-flex>
		  		<v-flex xs12 sm4>
		  			<v-text-field
		  			class="py-0 pr-3"
		  			v-model="tcDiaDiemDKKTHS"
		  			clearable
		  			placeholder="Nhập địa điểm kiểm tra"
		  			></v-text-field>
		  		</v-flex>
		  		<v-flex xs12 sm2 class="text-xs-center">
		  			<input type="checkbox" class="mt-3" id="checkboxMauXe" v-model="tcMauXeCBHS"> <label for="checkboxMauXe">Chọn mẫu xe</label>
		  		</v-flex>
		  		<v-flex xs12 sm4>
		  			<v-text-field
		  			class="py-0 pr-3"
		  			clearable
		  			v-model="tcLoaiPhuongTienGTHS"
		  			placeholder="Gõ tay [loại phương tiện /loại động cơ nhập khẩu]"
		  			></v-text-field>
		  		</v-flex>
		  		<!-- ---------------- -->
		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Địa điểm ĐKKT</label>
		  		</v-flex>
		  		<v-flex xs12 sm4>
		  			<v-select
		  			item-text="itemName"
		  			item-value="itemCode"
		  			clearable
		  			:items="tcDiaDiemItems"
		  			placeholder="-------Lựa chọn--------"
		  			v-model="tcDiaDiemSLHS"
		  			class="py-0 pr-3"
		  			></v-select>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Nhãn hiệu</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcNhanHieuHS"
		  					placeholder="Nhập nhãn hiệu"
		  					></v-text-field>
		  				</v-flex>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Mã kiểu loại</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcMaKieuLoaiHS"
		  					placeholder="Nhập mã kiểu loại"
		  					></v-text-field>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Đơn vị kiểm tra</label>
		  		</v-flex>
		  		<v-flex xs12 sm4>
		  			<v-select
		  			item-text="itemName"
		  			item-value="itemCode"
		  			:items="tcDonViKiemTraItems"
		  			clearable
		  			placeholder="------Lựa chọn--------"
		  			v-model="tcDonViKiemTraHS"
		  			class="py-0 pr-2"
		  			></v-select>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Tên thương mại</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					v-model="tcTenThuongMaiHS"
		  					clearable
		  					placeholder="Nhập tên thương mại"
		  					></v-text-field> 
		  				</v-flex>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Số PIN /Sê ri</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					v-model="tcSoPinSoSerialHS"
		  					clearable
		  					placeholder="Nhập số PIN hoặc số serial"
		  					></v-text-field>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Đăng kiểm viên</label>
		  		</v-flex>
		  		<v-flex xs12 sm4>
		  			<v-select
		  			:items="tcDangKiemVienItems"
		  			clearable
		  			placeholder="------Lựa chọn--------"
		  			v-model="tcDangKiemVienHS"
		  			class="py-0 pr-2"
		  			></v-select>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Số khung/ số Vin</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					v-model="tcSoKhungSoVinHS"
		  					clearable
		  					placeholder="Nhập số khung số VIN"
		  					></v-text-field>
		  				</v-flex>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Số động cơ</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					v-model="tcSoDongCoHS"
		  					clearable
		  					placeholder="Nhập số động cơ"
		  					></v-text-field>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>
      
		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Doanh nghiệp</label>
		  		</v-flex>
		  		<v-flex xs12 sm4>
		  			<v-text-field
		  			class="py-0 pr-2"
		  			v-model="tcDoanhNghiepHS"
		  			clearable
		  			placeholder="Nhập tên doanh nghiệp"
		  			></v-text-field> 
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Nước sản xuất</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcNuocSanXuatHS"
		  					placeholder="Nhập nước sản xuất"
		  					></v-text-field> 
		  				</v-flex>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Năm sản xuất</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-select
		  					:items="tcNamItems"
		  					clearable
		  					placeholder="------Lựa chọn--------"
		  					v-model="tcNamSXHS"
		  					class="py-0"
		  					></v-select>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Mã số thuế</label>
		  		</v-flex>
		  		<v-flex xs12 sm4 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm4>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcMaSoThueHS"
		  					placeholder="Nhập mã số thuế"
		  					></v-text-field> 
		  				</v-flex>
		  				<v-flex xs12 sm4 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Số hóa đơn</label>
		  				</v-flex>
		  				<v-flex xs12 sm4>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcSoHoaDonHS"
		  					placeholder="Nhập số hóa đơn"
		  					></v-text-field> 
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  				</v-flex>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Màu sơn</label>
		  				</v-flex>
		  				<v-flex xs12 sm3>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcMauSonHS"
		  					placeholder="Nhập màu sơn"
		  					></v-text-field> 
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Số BCTN an toàn</label>
		  		</v-flex>

		  		<v-flex xs12 sm4>
		  			<v-text-field
		  			class="py-0"
		  			clearable
		  			v-model="tcSoBCTNAnToanHS"
		  			placeholder="Nhập số báo cáo thử nghiệm an toàn"
		  			></v-text-field> 
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-right">
		  					<label class="mr-3 my-0" style="padding-top: 6px;">Tên nhà máy SX</label>
		  				</v-flex>
		  				<v-flex xs12 sm9>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcTenNhaMaySXHS"
		  					placeholder="Nhập tên nhà máy sản xuất"
		  					></v-text-field>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>


		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Số BCTN khí thải</label>
		  		</v-flex>

		  		<v-flex xs12 sm4>
		  			<v-text-field
		  			class="py-0 pr-2"
		  			clearable
		  			v-model="tcSoBCTNKhiThaiHS"
		  			placeholder="Nhập số báo cáo thử nghiệm khí thải"
		  			></v-text-field>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-left">
		  					<label class="my-0" style="padding-top: 6px;">Đ.chỉ nhà máy SX</label>
		  				</v-flex>
		  				<v-flex xs12 sm9>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcDiaChiNhaMaySXHS"
		  					placeholder="Nhập địa chỉ nhà máy sản xuất"
		  					></v-text-field>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Số BC COP</label>
		  		</v-flex>

		  		<v-flex xs12 sm4>
		  			<v-text-field
		  			class="py-0 pr-2"
		  			clearable
		  			v-model="tcSoBCCOPHS"
		  			placeholder="Nhập số báo cáo COP"
		  			></v-text-field>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap>
		  				<v-flex xs12 sm3 class="text-xs-left">
		  					<label class="my-0" style="padding-top: 6px;">Tiêu chuẩn khí thải</label>
		  				</v-flex>
		  				<v-flex xs12 sm9>
		  					<v-text-field
		  					class="py-0"
		  					clearable
		  					v-model="tcTieuChuanKhiThaiHS"
		  					placeholder="Nhập tiêu chuẩn khí thải"
		  					></v-text-field>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>

		  		<v-flex xs12 sm2 class="text-xs-right">
		  			<label class="mr-3 my-0" style="padding-top: 6px;">Phương thức cấp phôi phiếu</label>
		  		</v-flex>

		  		<v-flex xs12 sm4>
		  			<v-select
		  			item-text="itemName"
		  			item-value="itemCode"
		  			clearable
		  			:items="tcPhuongThucCapPPItems"
		  			placeholder="------Lựa chọn--------"
		  			v-model="tcPhuongThucCapPPHS"
		  			class="py-0 pr-2"
		  			></v-select>
		  		</v-flex>

		  		<v-flex xs12 sm6 class="pl-3">
		  			<v-layout row wrap class="ml-0">
		  				<v-flex xs12 sm6 class="text-xs-left">
		  					<label class="mt-3">Ghi chú &nbsp;&nbsp;&nbsp; <span style="color: red;">(*)</span> Chỉ lọc thông số kỹ thuật theo </label>
		  				</v-flex>
		  				<v-flex xs12 sm6 class="text-xs-right pr-3">
		  					<input type="checkbox" class="mt-3" id="checkboxDoiTuong" v-model="tcDoiTuongCbHS"> <label for="checkboxDoiTuong">Đối tượng</label>
		  					<input type="checkbox" id="checkboxLoaiPT" v-model="tcLoaiPhuongTienCbHS"> <label for="checkboxLoaiPT">Loại phương tiện</label>
		  				</v-flex>
		  			</v-layout>
		  		</v-flex>
		  	</div>
		  	<v-layout wrap>
		  		<v-flex xs12 class="text-xs-right">
		  			<v-btn color="primary" small class="mx-0 my-0 mt-2" v-on:click.native.prevent="advanced_filter_btn_click">Tìm kiếm</v-btn>
		  		</v-flex>
		  	</v-layout>
	</div>
</v-slide-y-transition>

<v-slide-x-transition>

    <div class="layout wrap" jx-bind="danhSachHoSoTable" v-if="!detailPage"></div>

</v-slide-x-transition>
