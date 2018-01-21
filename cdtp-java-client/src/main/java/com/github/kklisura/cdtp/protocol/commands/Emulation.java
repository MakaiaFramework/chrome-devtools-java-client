package com.github.kklisura.cdtp.protocol.commands;

import com.github.kklisura.cdtp.protocol.annotations.Experimental;
import com.github.kklisura.cdtp.protocol.annotations.Optional;
import com.github.kklisura.cdtp.protocol.annotations.ParamName;
import com.github.kklisura.cdtp.protocol.annotations.Returns;
import com.github.kklisura.cdtp.protocol.types.dom.RGBA;
import com.github.kklisura.cdtp.protocol.types.emulation.Configuration;
import com.github.kklisura.cdtp.protocol.types.emulation.ScreenOrientation;
import com.github.kklisura.cdtp.protocol.types.emulation.VirtualTimePolicy;

/**
 * This domain emulates different environments for the page.
 */
public interface Emulation {

	/**
	 * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
	 */
	void setDeviceMetricsOverride(@ParamName("width") Integer width, @ParamName("height") Integer height, @ParamName("deviceScaleFactor") Double deviceScaleFactor, @ParamName("mobile") Boolean mobile, @Optional @ParamName("scale") Double scale, @Experimental @Optional @ParamName("screenWidth") Integer screenWidth, @Experimental @Optional @ParamName("screenHeight") Integer screenHeight, @Experimental @Optional @ParamName("positionX") Integer positionX, @Experimental @Optional @ParamName("positionY") Integer positionY, @Experimental @Optional @ParamName("dontSetVisibleSize") Boolean dontSetVisibleSize, @Optional @ParamName("screenOrientation") ScreenOrientation screenOrientation);

	/**
	 * Clears the overriden device metrics.
	 */
	void clearDeviceMetricsOverride();

	/**
	 * Requests that page scale factor is reset to initial values.
	 */
	@Experimental
	void resetPageScaleFactor();

	/**
	 * Sets a specified page scale factor.
	 */
	@Experimental
	void setPageScaleFactor(@ParamName("pageScaleFactor") Double pageScaleFactor);

	/**
	 * Resizes the frame/viewport of the page. Note that this does not affect the frame's container (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported on Android.
	 */
	@Deprecated
	@Experimental
	void setVisibleSize(@ParamName("width") Integer width, @ParamName("height") Integer height);

	/**
	 * Switches script execution in the page.
	 */
	@Experimental
	void setScriptExecutionDisabled(@ParamName("value") Boolean value);

	/**
	 * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
	 */
	@Experimental
	void setGeolocationOverride(@Optional @ParamName("latitude") Double latitude, @Optional @ParamName("longitude") Double longitude, @Optional @ParamName("accuracy") Double accuracy);

	/**
	 * Clears the overriden Geolocation Position and Error.
	 */
	@Experimental
	void clearGeolocationOverride();

	/**
	 * Enables touch on platforms which do not support them.
	 */
	void setTouchEmulationEnabled(@ParamName("enabled") Boolean enabled, @Optional @ParamName("maxTouchPoints") Integer maxTouchPoints);

	@Experimental
	void setEmitTouchEventsForMouse(@ParamName("enabled") Boolean enabled, @Optional @ParamName("configuration") Configuration configuration);

	/**
	 * Emulates the given media for CSS media queries.
	 */
	void setEmulatedMedia(@ParamName("media") String media);

	/**
	 * Enables CPU throttling to emulate slow CPUs.
	 */
	@Experimental
	void setCPUThrottlingRate(@ParamName("rate") Double rate);

	/**
	 * Tells whether emulation is supported.
	 */
	@Experimental
	@Returns("result")
	Boolean canEmulate();

	/**
	 * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and sets the current virtual time policy.  Note this supersedes any previous time budget.
	 */
	@Experimental
	void setVirtualTimePolicy(@ParamName("policy") VirtualTimePolicy policy, @Optional @ParamName("budget") Integer budget);

	/**
	 * Overrides value returned by the javascript navigator object.
	 */
	@Experimental
	void setNavigatorOverrides(@ParamName("platform") String platform);

	/**
	 * Sets or clears an override of the default background color of the frame. This override is used if the content does not specify one.
	 */
	@Experimental
	void setDefaultBackgroundColorOverride(@Optional @ParamName("color") RGBA color);
}