typesystem edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystem
ecore file "platform:/resource/edu.kit.iti.formal.pse.worthwhile.model/model/WorthwhilePlain.ecore"
language package edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage

section "BaseTypes"
		typeof Type -> abstract
		typeof PrimitiveType -> abstract
		typeof ArrayType -> feature baseType {
			ensureType size :<=: IntegerType
			ensureType baseType :<=: PrimitiveType
		}
		typeof IntegerType -> clone
		typeof BooleanType -> clone
		
section "Literals"
		typeof Literal -> abstract
		typeof BooleanLiteral -> BooleanType
		typeof IntegerLiteral -> IntegerType
		typeof ArrayLiteral -> ArrayType
		
section "Variables"
		typeof VariableDeclaration -> feature type
	    typeof Assignment -> feature variable {
	    	ensureType value :<=: Type
	    	ensureCompatibility variable :<=>: value
	    }
	    typeof VariableReference -> feature variable
	
	    
	    
section "Expressions"
		typeof Expression + -> abstract
		typeof QuantifiedExpression +->  feature expression {
		ensureType condition :<=: BooleanType //TODO
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
			ensureType left :<=: PrimitiveType
		 	ensureType right :<=: PrimitiveType
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
		
		
		
section "Functions"
	typeof FunctionDeclaration -> feature returnType {
		ensureType returnType :<=: Type
	
		
	}
	typeof ReturnStatement -> javacode {
		ensureType returnValue :<=: Type
	}
	typeof FunctionCall -> feature function 

	
		
		 
		 
		 