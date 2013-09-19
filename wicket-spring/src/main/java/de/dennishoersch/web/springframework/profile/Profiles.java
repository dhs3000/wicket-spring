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
package de.dennishoersch.web.springframework.profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * @author hoersch
 */
public enum Profiles implements de.dennishoersch.web.springframework.profile.SetProfileContextListener.Profile {
	DEVELOPMENT {
		@Override
		public void init() {
			System.setProperty("wicket.configuration", "development");
		}

		@Override
		public boolean isActive(ConfigurableWebApplicationContext applicationContext) {
			return !(QA.isActive(applicationContext) || PREVIEW.isActive(applicationContext) || PRODUCTION.isActive(applicationContext));
		}
	},
	QA {
		@Override
		public void init() {
			System.setProperty("wicket.configuration", "development");
		}

		@Override
		public boolean isActive(ConfigurableWebApplicationContext applicationContext) {
			// FIXME implement environment detection
			return false;
		}
	},
	PREVIEW {
		@Override
		public void init() {
			System.setProperty("wicket.configuration", "deployment");
		}

		@Override
		public boolean isActive(ConfigurableWebApplicationContext applicationContext) {
			// FIXME implement environment detection
			return false;
		}
	},
	PRODUCTION {
		@Override
		public void init() {
			System.setProperty("wicket.configuration", "deployment");
		}

		@Override
		public boolean isActive(ConfigurableWebApplicationContext applicationContext) {
			// FIXME implement environment detection
			return false;
		}
	};

	@Override
	public void init() {
		//
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Profile("DEVELOPMENT")
	public @interface Development {
		//
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Profile("QA")
	public @interface QA {
		//
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Profile("PREVIEW")
	public @interface Preview {
		//
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Profile("PRODUCTION")
	public @interface Production {
		//
	}
}
