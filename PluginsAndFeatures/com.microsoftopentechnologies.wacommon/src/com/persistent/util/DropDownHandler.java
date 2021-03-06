package com.persistent.util;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;

public class DropDownHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (event.getTrigger() != null && (event.getTrigger() instanceof Event)) {
			pullDropdown((Event) event.getTrigger());
		}
		return null;
	}

	public void pullDropdown(Event event) {
		Widget widget = event.widget;
		if (widget instanceof ToolItem) {
			ToolItem toolItem = (ToolItem) widget;
			Listener[] listeners = toolItem.getListeners(SWT.Selection);
			if (listeners.length > 0) {
				Listener listener = listeners[0];
				Event eve = new Event();
				eve.type = SWT.Selection;
				eve.widget = toolItem;
				eve.detail = SWT.DROP_DOWN;
				eve.x = toolItem.getBounds().x;
				eve.y = toolItem.getBounds().height;
				listener.handleEvent(eve);
			}
		}
	}
}
