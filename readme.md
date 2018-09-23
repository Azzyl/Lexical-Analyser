##### KeywordToken: 
Keywords (reserved words) using in eiffel that are not operatos or separators
##### LiteralToken: 
Literals written in program, such as numericals or strings in format "string"
##### NewLineToken: 
Newline symbol \n
##### OperatorToken: 
Operators used in eiffel, including symbols (ex: +, -, $) and reserved words (ex: implies)
##### SeparatorToken: 
Separators used in eiffel, including symbols (ex: {, ( ) and reserved words (ex: do, end)
#####IdentifierToken: 
Names of variables, classes , etc. Everything written in programm which is not reserved.


##### A.N.
1) Eiffel doesn't contain primitive datatypes (they are all classes) so we don't consider them as keywords
2) Some operators and separators may be complex (ex: :=, <<) but we recognize them as single ones (ex : and =, < and <) considering further parsing in syntax and semantic analysis
