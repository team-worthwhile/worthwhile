		package edu.kit.iti.formal.pse.worthwhile.typesys;

		import org.eclipse.emf.ecore.EObject;
		import de.itemis.xtext.typesystem.exceptions.TypesystemConfigurationException;
		import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

		public class WorthwhileTypesystemGenerated extends de.itemis.xtext.typesystem.DefaultTypesystem {

			protected edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage p = edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage.eINSTANCE;

			protected void initialize() {

				try {

						// ----------------------------------------------------------------
						// Section: BaseTypes

						useTypeOfFeature( p.getArrayType(), p.getArrayType_BaseType() );
						useCloneAsType( p.getIntegerType() );
						useCloneAsType( p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Literals

						// include subtypes!
						useFixedType( p.getBooleanLiteral(), p.getBooleanType() );
						// ------
						useFixedType( p.getIntegerLiteral(), p.getIntegerType() );
						useFixedType( p.getArrayLiteral(), p.getArrayType() );

						// ----------------------------------------------------------------
						// Section: Variables

						useTypeOfFeature( p.getVariableDeclaration(), p.getVariableDeclaration_Type() );
						useTypeOfFeature( p.getAssignment(), p.getAssignment_Variable() );
						ensureUnorderedCompatibility( p.getAssignment(), p.getAssignment_Variable(), p.getAssignment_Value() );
						useTypeOfFeature( p.getVariableReference(), p.getVariableReference_Variable() );

				} catch ( TypesystemConfigurationException ex ) {
				}
			}


		}
