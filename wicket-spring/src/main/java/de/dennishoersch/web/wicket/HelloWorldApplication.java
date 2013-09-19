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
package de.dennishoersch.web.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import de.dennishoersch.web.wicket.pages.HelloPage;

/**
 * @author hoersch
 * 
 */
public class HelloWorldApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		getMarkupSettings().setDefaultMarkupEncoding("utf-8");
		getRequestCycleSettings().setResponseRequestEncoding("utf-8");
		getMarkupSettings().setCompressWhitespace(true);

		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		// getComponentInstantiationListeners().add(new SimpleSpringComponentInjector(getServletContext()));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return HelloPage.class;
	}

}
