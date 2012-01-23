package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;

/**
 * A custom {@link NamesAreUniqueValidationHelper} with a specialized error message.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {

	@Override
	public final String getDuplicateNameErrorMessage(final IEObjectDescription description,
	                final EClass clusterType, final EStructuralFeature feature) {
		EObject object = description.getEObjectOrProxy();
		String shortName = String.valueOf(feature != null ? object.eGet(feature) : "<unnamed>");

		return "Duplicate identifier '" + shortName + "'";
	}

}
