package de.dennishoersch.web.wicket.components;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.dennishoersch.web.wicket.util.Components;

public class LabelAndInput extends Panel {
	private static final long serialVersionUID = 1L;

	public LabelAndInput(String id, IModel<?> model) {
		super(id, null/*model*/);
		//add(new Label("label")); // key setzt sich woraus zusammen? wenn man propertymodel hätte, dann darüber + diese id? wenn compondproertymodel dann über parent?

		// der würde ja mit dem zusammengesetzten model im parent model unter der Id 'input' suchen...
		// und mit direktem model, dann ja nicht an super weitergeben, oder?

		add(new TextField("input", model).setLabel(Model.of("LABEL")));
		add(optionalHelptext());
	}

	private Component optionalHelptext() {
		// irgendwo muss der Text hinterlegt werden ujnd der Button ein Ajax on click bekommen?
		return Components.invisible("helptextButton");
	}




}
