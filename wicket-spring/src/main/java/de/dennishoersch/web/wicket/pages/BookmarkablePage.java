/*
 * Copyright 2012-2013 Dennis Hörsch.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dennishoersch.web.wicket.pages;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.google.common.base.Strings;

import de.dennishoersch.web.wicket.util.Components;

/**
 * @author hoersch
 */
public class BookmarkablePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public BookmarkablePage(final PageParameters parameters) {
		add(createLabel("parameter", parameters));
	}

	private Component createLabel(String labelId, PageParameters parameters) {
		if (parameters != null) {
			StringValue value = parameters.get("parameter1");
			if (!Strings.isNullOrEmpty(value.toString())) {
				return new Label(labelId, "Ich habe den Parameter '" + value.toString() + "'!!");
			}
		}
		return Components.invisible(labelId);
	}

}
