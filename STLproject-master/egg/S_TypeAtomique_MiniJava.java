package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_TypeAtomique_MiniJava {
LEX_MiniJava scanner;
  S_TypeAtomique_MiniJava() {
	}
  S_TypeAtomique_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Type att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  private void regle45() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_String);
if  (att_eval)	  action_ast_45();
  }
  private void regle46() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_identificateur_type);
if  (att_eval)	  action_ast_46(x_2);
  }
  private void regle42() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_bool);
if  (att_eval)	  action_ast_42();
  }
  private void regle43() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_int);
if  (att_eval)	  action_ast_43();
  }
  private void regle44() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_char);
if  (att_eval)	  action_ast_44();
  }
private void action_ast_42() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createBooleanType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_bool #ast ;", e });
}
  }
private void action_ast_43() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createIntegerType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_int #ast ;", e });
}
  }
private void action_ast_44() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createCharType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_char #ast ;", e });
}
  }
private void action_ast_45() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createStringType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_String #ast ;", e });
}
  }
private void action_ast_46(T_MiniJava x_2) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
// instructions
if (this.att_tdsInterface.contains(x_2.att_txt)){
loc_f=this.att_tdsInterface.get(x_2.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof Interface ){
this.att_ast=this.att_factory.createInterfaceType(((Interface)loc_d));
}

}
else if (this.att_tdsClasses.contains(x_2.att_txt)){
loc_f=this.att_tdsClasses.get(x_2.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof Classe ){
this.att_ast=this.att_factory.createClassType(((Classe)loc_d));
}

}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Identificateur_Type_undefined, MiniJavaMessages.Identificateur_Type_undefined,new Object[]{""+x_2.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> identificateur_type #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 87
        regle42 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle43 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle44 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle45 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle46 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
