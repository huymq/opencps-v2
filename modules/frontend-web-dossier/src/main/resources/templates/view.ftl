
<#include "init.ftl">

<input type="hidden" id="employeeTitle" name="employeeTitle" value="${(employee.title)!}">
<input type="hidden" id="employeeFullName" name="employeeFullName" value="${(employee.fullName)!}">

<div class="application theme--light">
  	<object id="plugin0" type="application/x-cryptolib05plugin" width="0" height="0"></object>
	<div id="dossierViewJX" style="width: 100%;"> </div>
	
</div>

<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function (event) {
		var stateWindow = "${(stateWindow)!}";
		var dossierId = '${(dossierId)!}';
		var dossierPartNo = "${(dossierPartNo)!}";

		var emailAddress = '${(user.emailAddress)!}';
		var urlCoSo = "${(ajax.saveDictItemURL)!}";
		var urlGetDictGroup = "${(getDictGroupURL)!}";
		var portletNamespace = "${(portletNamespace)!}";

		funLoadVue(stateWindow, dossierId, dossierPartNo, emailAddress, urlCoSo, urlGetDictGroup, portletNamespace);
	});
	
</script>
<style>
	.expansion-header-registration>div.expansion-panel__header {
		padding: 8px 22px !important;
		background-color: #eceaea !important;
		border-bottom: 1px solid #ccc;
	}
</style>