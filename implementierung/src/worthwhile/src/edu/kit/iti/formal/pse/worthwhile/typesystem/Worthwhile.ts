typesystem edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystem
ecore file "platform:/resource/edu.kit.iti.formal.pse.worthwhile.model/model/WorthwhilePlain.ecore"
language package edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage

section "BaseTypes"
		typeof Type -> abstract
		typeof PrimitiveType -> abstract
		typeof ArrayType -> clone {
			ensureType size :<=: IntegerType
			ensureType baseType :<=: BooleanType, IntegerType
		}
		typeof IntegerType -> clone
		typeof BooleanType -> clone
		
section "Literals"
		typeof Literal -> abstract
		typeof BooleanLiteral -> BooleanType
		typeof IntegerLiteral -> IntegerType
		typeof ArrayLiteral -> ArrayType 
section "Variables"
		typeof VariableDeclaration -> feature type {
			ensureType type :<=: BooleanType, IntegerType, ArrayType
			ensureCompatibility initialValue :<=>: type
		}
	    typeof Assignment -> feature variable {
	    	ensureType value :<=: BooleanType, IntegerType, ArrayType
	    	ensureCompatibility variable :<=>: value
	    }
	    typeof VariableReference -> feature variable
	
	    
	    
section "Expressions"
		typeof Expression + -> abstract
		typeof QuantifiedExpression -> clone {
			
			ensureType parameter :<=: BooleanType, IntegerType
			ensureType expression :<=: BooleanType, ForAllQuantifier, ExistsQuantifier
			ensureType condition :<=: BooleanType 
			
		}
		typeof ForAllQuantifier -> clone
		typeof ExistsQuantifier -> clone
		
section "Annotation"
		typeof Assumption -> abstract {
			ensureType expression :<=: BooleanType, QuantifiedExpression			
		}
		typeof Assertion -> abstract {
			ensureType expression :<=: BooleanType, QuantifiedExpression
		}
		typeof Postcondition -> abstract {
			ensureType expression :<=: BooleanType, QuantifiedExpression
		}
		typeof Precondition -> abstract {
			ensureType expression :<=: BooleanType, QuantifiedExpression
		}
		typeof Invariant -> abstract {
			ensureType expression :<=: BooleanType, QuantifiedExpression
		}

section "Binary Expression with integer operands"

		//-BinaryExprssion with integer operands
			//--and have return type IntegerType
		typeof Addition -> common left right {
			ensureType left :<=: IntegerType 
		 	ensureType right :<=: IntegerType 
		 	ensureCompatibility left :<=>: right "Both summands have to be an Integer or an expression which returns an integer"
		 }
		 typeof Subtraction -> common left right {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both minuend and subtrahend have to be an Integer or an expression which returns an integer"
		 }
		 typeof Multiplication -> common left right {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both factors have to be an Integer or an expression which returns an integer"
		 }
		 typeof Modulus -> common left right {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be an Integer or an expression which returns an integer"
		 }
		 typeof Division -> common left right {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both dividend and divisor have to be an Integer or an expression which returns an integer"
		}
			 //--and have return type BooleanType
		 typeof LessOrEqual -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be an Integer or an expression which returns an integer"
		 }
		 
		 typeof Less -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be an Integer or an expression which returns an integer"
		 	
		 }
		 typeof Greater -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be an Integer or an expression which returns an integer"
		 }
		 
		 typeof GreaterOrEqual -> BooleanType {
			ensureType left :<=: IntegerType
		 	ensureType right :<=: IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be an Integer or an expression which returns an integer"
		 }
section "Binary Expression with boolean operands"
		 	
		 typeof Disjunction -> BooleanType {
			ensureType left :<=: BooleanType
		 	ensureType right :<=: BooleanType
		 	ensureCompatibility left :<=>: right "Both operands have to be be a value of Boolean or an expression which returns an value of Boolean"
		 }
		 typeof Conjunction -> BooleanType {
			ensureType left :<=: BooleanType
		 	ensureType right :<=: BooleanType
		 	ensureCompatibility left :<=>: right "Both operands have to be be a value of Boolean or an expression which returns an value of Boolean"
		 }
section "Binary Expression with boolean operands or integer operands"

		  typeof Equal -> BooleanType {
			ensureType left :<=: BooleanType, IntegerType
		 	ensureType right :<=: BooleanType, IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be of the same type"
		 }
		 typeof Unequal -> BooleanType {
		 	ensureType left :<=: BooleanType, IntegerType
		 	ensureType right :<=: BooleanType, IntegerType
		 	ensureCompatibility left :<=>: right "Both operands have to be be of the same type"
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
		typeof ArrayLength -> IntegerType {
			ensureType operand :<=: ArrayType "The Operand has to be an array"
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
	typeof ReturnStatement -> abstract {
		ensureType returnValue :<=: BooleanType, IntegerType, ArrayType
	}
	typeof FunctionCall -> feature function 
	 
		 