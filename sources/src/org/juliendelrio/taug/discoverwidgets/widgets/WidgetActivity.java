package org.juliendelrio.taug.discoverwidgets.widgets;

import org.juliendelrio.taug.discoverwidgets.R;
import org.juliendelrio.taug.discoverwidgets.tools.WidgetDescriptorConfiguration;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;

public class WidgetActivity extends WidgetBase {
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	@Override
	public RemoteViews buildUpdate(Context context, int appWidgetId) {
		RemoteViews views = super.buildUpdate(context, appWidgetId);

		WidgetDescriptorConfiguration widgetDescriptorConfiguration = WidgetDescriptorConfiguration
				.restoreFromId(context, appWidgetId);

		if (widgetDescriptorConfiguration != null) {
			if (widgetDescriptorConfiguration.isBgHidden()) {
				views.setInt(R.id.widget_base_root, "setBackgroundResource",
						android.R.color.transparent);
			}

			String customText = widgetDescriptorConfiguration.getCustomText();
			if (customText != null && !customText.trim().equals("")) {
				views.setTextViewText(R.id.widget_base_tvlastrefresh,
						customText);
			}
		}
		return views;
	}

	@Override
	protected int getBaseLabelId() {
		return R.string.widget_conf_activity_label;
	}
}
