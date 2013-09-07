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

package de.dennishoersch.web.springframework.wicket;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.wicket.Component;
import org.apache.wicket.IBehaviorInstantiationListener;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.behavior.Behavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Supports @{@link Inject} and @{@link Autowired} for injecting dependencies into Wicket components like in any other spring bean.
 * 
 * @author hoersch
 */
public class SimpleSpringComponentInjector implements IComponentInstantiationListener, IBehaviorInstantiationListener {

    private final ServletContext _servletContext;

    public SimpleSpringComponentInjector(final ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Override
    public void onInstantiation(Behavior behavior) {
        inject(behavior);
    }

    @Override
    public void onInstantiation(Component component) {
        inject(component);
    }

    private void inject(Object object) {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(object, _servletContext);
    }
}
