typesystem edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystem
ecore file "platform:/resource/edu.kit.iti.formal.pse.worthwhile.model/model/WorthwhilePlain.ecore"
language package edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage

section "BaseTypes"
		typeof Type -> abstract
		typeof PrimitiveType -> abstract
		typeof ArrayType -> clone {
			ensureType baseType :<=: BooleanType, IntegerType
		}
		typeof IntegerType -> clone
		typeof BooleanType -> clone
		
section "Literals"
		typeof Literal -> abstract
		typeof BooleanLiteral -> BooleanType
		typeof IntegerLiteral -> IntegerType
		typeof ArrayFunction -> javacode
		typeof ArrayLiteral -> javacode
 
	

section "Variables"
		typeof VariableDeclaration -> feature  type {
			ensureType type :<=: BooleanType, IntegerType, ArrayType
			ensureCompatibility initialValue :<=>: type 
		}
	    typeof Assignment -> feature variable {
	    	ensureType value :<=: BooleanType, IntegerType, ArrayType
	    	ensureCompatibility variable :<=>: value
	    }
		   typeof VariableReference -> javacode {
	    	ensureType index :<=: IntegerType
	    }
	    typeof ReturnValueReference -> javacode
	
	    
	    
section "Expressions"
		typeof Expression + -> abstract
		typeof ForAllQuantifier -> BooleanType
		typeof ExistsQuantifier -> BooleanType		
		typeof QuantifiedExpression -> BooleanType {
			
			ensureType expression :<=: BooleanType
			ensureType condition :<=: BooleanType 
			
		}
		
		
section "Annotation"
		typeof Assumption -> abstract {
			ensureType expression :<=: BooleanType			
		}
		typeof Assertion -> abstract {
			ensureType expression :<=: BooleanType
		}
		typeof Postcondition -> abstract {
			ensureType expression :<=: BooleanType
		}
		typeof Precondition -> abstract {
			ensureType expression :<=: BooleanType
		}
		typeof Invariant -> abstract {
			ensureType expression :<=: BooleanType
		}

section "Binary Expression with integer operands"

		//-BinaryExprssion with integer operands
			//--and have return type IntegerType
		typeof Addition -> IntegerType {
			ensureType left :<=: IntegerType 
		 	ensureType right :<=: IntegerType 
		 	ensureCompatibility left :<=>: right 
		 }
		 typeof Subtraction -> IntegerType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 }
		 typeof Multiplication -> IntegerType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 }
		 typeof Modulus -> IntegerType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 }
		 typeof Division -> IntegerType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		}
			 //--and have return type BooleanType
		 typeof LessOrEqual -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 }
		 
		 typeof Less -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 	
		 }
		 typeof Greater -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 }
		 
		 typeof GreaterOrEqual -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right 
		 }
section "Binary Expression with boolean operands"
		 	
		 typeof Disjunction -> BooleanType {
			ensureType left :<=: BooleanType
		 	ensureType right :<=: BooleanType
		 	ensureCompatibility left :<=>: right
		 }
		 typeof Conjunction -> BooleanType {
			ensureType left :<=: BooleanType
		 	ensureType right :<=: BooleanType
		 	ensureCompatibility left :<=>: right 
		 }
		 typeof Equivalence -> BooleanType {
			ensureType left :<=: BooleanType
		 	ensureType right :<=: BooleanType
		 	ensureCompatibility left :<=>: right 
		 }
		 typeof Implication -> BooleanType {
			ensureType left :<=: BooleanType
		 	ensureType right :<=: BooleanType
		 	ensureCompatibility left :<=>: right 
		 }
section "Binary Expression with boolean, integer or array operands"

		  typeof Equal -> BooleanType {
			ensureType left :<=: BooleanType, IntegerType, ArrayType
		 	ensureType right :<=: BooleanType, IntegerType, ArrayType
		 	ensureCompatibility left :<=>: right "Both operands have to be be of the same type"
		 }
		 typeof Unequal -> BooleanType {
		 	ensureType left :<=: BooleanType, IntegerType, ArrayType
		 	ensureType right :<=: BooleanType, IntegerType, ArrayType
		 	ensureCompatibility left :<=>: right "Both operands have to be be of the same type"
		 }
		typeof ArrayAccess -> javacode {
			ensureType array :<=: ArrayType
			ensureType index :<=: IntegerType
		}

section "Unary Expression"

		typeof Negation -> BooleanType {
			ensureType operand :<=: BooleanType "Only a Boolean operand can be negated"
		}
		typeof Plus -> feature operand {
			ensureType operand :<=: IntegerType "Only Integers have signs"
		}
		typeof Minus -> feature operand {
			ensureType operand :<=: IntegerType "Only Integers have signs"
		}
		
section "Conditional"

		typeof Conditional -> abstract {
			ensureType condition :<=: BooleanType "Has to be be a value of Boolean or an expression which returns an value of Boolean"
		}
		typeof Loop -> abstract {
			ensureType condition :<=: BooleanType "Has to be be a value of Boolean or an expression which returns an value of Boolean"
		}
		
		
section "Functions"
	typeof FunctionDeclaration -> feature returnType {
		ensureType returnType :<=: BooleanType, IntegerType, ArrayType
		
	}
	typeof ReturnStatement -> feature returnValue {
		ensureType returnValue :<=: BooleanType, IntegerType, ArrayType
	}
	typeof FunctionCall -> feature function 
	 
		 