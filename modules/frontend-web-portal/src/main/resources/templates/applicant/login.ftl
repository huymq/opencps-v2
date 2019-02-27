<#if (Request)??>
<#include "init.ftl">
</#if>

<#if isSignedIn == false>
<div class="">
	<form action="${loginURL}" method="post" class="eq-height-lg" name="login_form">
		<input name="${portletNamespace}action" id="input_action" type="hidden"/>
		<div class="row">
			<div class="col-sm-6">
				<div class="">
					<input type="text" class="form-control input-sm" name="${portletNamespace}login" id="input_login" placeholder="Tài khoản đăng nhập" title="Tài khoản đăng nhập">
				</div>
			</div>
			<div class="col-sm-6">
				<div class="">
					<input type="password" class="form-control input-sm" name="${portletNamespace}password" id="input_password" placeholder="Mật khẩu" title="Mật khẩu">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				
				<a href="/forgotten-password" class="text-hover-blue">Quên mật khẩu?</a>
				
			</div>
			<div class="col-sm-6 text-right">
				<button class="btn btn-active btn-sm" type="button" id="btn-register-applicant">Đăng ký</button>
				<button class="btn btn-active btn-sm">Đăng nhập</button>
			</div>
		</div>
		
	</form>
</div>

<div class="visible-xs visible-sm">
	<a href="#">Đăng nhập</a>
</div>
<#else>
<div class="account-section align-middle">
	<a href="" class="notification-alert">
		<i class="fa fa-bell-o" aria-hidden="true"></i>
		<span>3</span>
	</a>
	<div class="account align-middle">
		<img src="http://via.placeholder.com/350x150" class="img-rounded">
		<div class="dropdown">
			<button class="btn btn-reset dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				<b id="userNameApplicant">${userName}</b>
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<#if userType == 'employee'>
				<li><a href="/group/cong-xu-ly/profile"><i class="fa fa-user"></i> Thông tin tài khoản</a></li>
				<#else>
				<li><a href="/group/cong-tiep-nhan/profile"><i class="fa fa-user"></i> Thông tin tài khoản</a></li>
				</#if>
				<li><a href="/c/portal/logout"><i class="fa fa-arrow-right"></i> Đăng xuất</a></li>
			</ul>
		</div>
	</div>
</div>
</#if>

<script type="text/javascript">
	$("#btn-register-applicant").click(function () {
		window.location.href = "/web/cong-tiep-nhan/register";
	});
	$(function () {
		var userName = $("#userNameApplicant").html();
		if (userName) {
			if (userName.indexOf('citizen') !== -1) {
				userName = userName.replace('citizen', '');
			}
			if (userName.indexOf('business') !== -1) {
				userName = userName.replace('business', '');
			}
		}
		$("#userNameApplicant").html(userName);

		$("ul[class='nav navbar-nav'] > li > a").each(function (index, value) {
			console.log(value.href);
			var hrefTmp = value.href;
			if (hrefTmp && hrefTmp.indexOf('cong-tiep-nhan/quan-ly-ho-so') !== -1) {
				if ('${(userType)!}' === 'applicant') {
					value.href = '/group/cong-tiep-nhan/quan-ly-ho-so'
				} else {
					value.href = '/group/cong-xu-ly/xu-ly-ho-so'
				}
			}
		});
	})
</script>
