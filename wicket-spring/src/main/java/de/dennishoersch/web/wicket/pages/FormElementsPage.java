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

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.dennishoersch.web.wicket.components.LabelAndInput;
import de.dennishoersch.web.wicket.model.Models;

/**
 * @author hoersch
 * 
 */
public class FormElementsPage extends BasePage {
	private static final long serialVersionUID = 1L;
	@Inject
	private Models models;

	public FormElementsPage(final PageParameters parameters) {
		Form<?> form = new Form<Void>("form");
		// TODO: Form model?
		form.add(new LabelAndInput("firstName", models.carModel(1)));
		form.add(new SubmitLink("sumit"));
		add(form);
	}
}
