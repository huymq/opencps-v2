package com.backend.migrate.vr.scheduler;

import java.util.Date;

import org.opencps.auth.utils.APIDateTimeUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.backend.migrate.vr.service.PhuongTienService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;

@Component(immediate = true, service = ILDBSyncScheduler.class)
public class ILDBSyncScheduler extends BaseSchedulerEntryMessageListener {
	@Override
	protected void doReceive(Message message) throws Exception {
		_log.info("DB sync is starting at  : "
				+ APIDateTimeUtils.convertDateToString(new Date()));
		
		_log.info("DB sync finished at  : " + APIDateTimeUtils.convertDateToString(new Date()));
	}
	
	@Activate
	@Modified
	protected void activate() {
		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),
				15, TimeUnit.SECOND));
		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
	}

	private SchedulerEngineHelper _schedulerEngineHelper;

	@Reference
	private PhuongTienService _phuongTienLocalService;

	private Log _log = LogFactoryUtil.getLog(ILDBSyncScheduler.class);	
}