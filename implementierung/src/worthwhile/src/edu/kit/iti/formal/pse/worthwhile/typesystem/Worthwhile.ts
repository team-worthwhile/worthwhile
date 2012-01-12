typesystem edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystem
ecore file "platform:/resource/edu.kit.iti.formal.pse.worthwhile.model/model/WorthwhilePlain.ecore"
language package edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage

section "BaseTypes"
		typeof Type -> abstract
		typeof PrimitiveType -> abstract
		typeof ArrayType -> feature baseType
		typeof IntegerType -> clone
		typeof BooleanType -> clone
		
	section "Literals"
		typeof Literal -> abstract
		typeof BooleanLiteral + -> BooleanType
		typeof IntegerLiteral -> IntegerType
		typeof ArrayLiteral -> ArrayType
		
	section "Variables"
		typeof VariableDeclaration -> feature type
	    typeof Assignment -> feature variable {
	    	ensureCompatibility variable :<=>: value
	    }
	    typeof VariableReference -> feature variable
	    /*typeof  -> javacode { // FIXME
	    	ensureType expr :<=: ArrayType
	    	ensureType index :<=: IntType "Array index must be an Integer"
	    }*/