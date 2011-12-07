typesystem org.xtext.example.mydsl.typesys.MyDslTypesystem
ecore file "platform:/resource/org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/MyDsl.ecore"
language package org.xtext.example.mydsl.myDsl.MyDslPackage

section "BaseTypes"
	typeof Type -> abstract
	typeof PrimitiveType -> abstract
	typeof ArrayType -> feature baseType
	typeof IntType -> clone
	typeof BoolType -> clone
	
section "Literals"
	typeof BooleanLiteral + -> BoolType
	typeof NumberLiteral -> IntType
	
section "Variables"
	typeof Variable -> feature type
	typeof VariableDeclaration -> feature type
    typeof Assignment -> feature variable {
    	ensureCompatibility variable :<=>: value
    }
    typeof VariableRef -> feature variable
    typeof ArrayAccess -> javacode { // FIXME
    	ensureType expr :<=: ArrayType
    	ensureType index :<=: IntType "Array index must be an Integer"
    }

section "Expressions"
	typeof Expression + -> abstract 
	typeof Expr + -> abstract

section "Arithmetic"
typeof Plus -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
}

typeof Minus -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
}

typeof Multi -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
}

typeof Div -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
}

typeof Modulo -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
}

typeof UnaryMinusOperator -> feature expr {
	ensureType expr :<=: IntType
}

typeof UnaryPlusOperator -> feature expr {
	ensureType expr :<=: IntType
}

typeof LessOrEqual -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
} 

typeof Less -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
} 

typeof Greater -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
} 

typeof GreaterOrEqual -> common left right {
	ensureType left :<=: IntType
 	ensureType right :<=: IntType
 	ensureCompatibility left :<=>: right
}

section "Boolean"
typeof And -> common left right {
	ensureType left :<=: BoolType
 	ensureType right :<=: BoolType
 	ensureCompatibility left :<=>: right
}

typeof Or -> common left right {
	ensureType left :<=: BoolType
 	ensureType right :<=: BoolType
 	ensureCompatibility left :<=>: right
} 

typeof UnaryNotOperator -> feature expr {
	ensureType expr :<=: BoolType
}

section "Equals"
	typeof Equals -> common left right {
		ensureType left :<=: BoolType, IntType
		ensureType right :<=: BoolType, IntType
		ensureCompatibility left :<=>: right
	}

section "Functions"
	typeof Parameter -> feature type
	typeof Function -> feature returnType	
	typeof FunctionCall -> feature expr
	typeof FunctionRef -> feature function
	typeof ReturnStatement -> javacode
	typeof FunctionCallActualParameter -> feature value