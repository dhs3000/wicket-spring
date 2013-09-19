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
package de.dennishoersch.web.wicket.util;

import org.apache.wicket.Component;


public final class Components {
	private Components() {
	}

	public static Component invisible(String id) {
		return new InvisibleComponent(id);
	}

	private static class InvisibleComponent extends Component {
		private static final long serialVersionUID = 1L;

		InvisibleComponent(String id) {
			super(id);
			setVisible(false);
		}


		@Override
		protected void onRender() {
		}
	}
}
