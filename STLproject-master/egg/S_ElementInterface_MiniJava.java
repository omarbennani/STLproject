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
public class S_ElementInterface_MiniJava {
LEX_MiniJava scanner;
  S_ElementInterface_MiniJava() {
	}
  S_ElementInterface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ElementInterface att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_identObjetCourant;
  private void regle11() throws Exception {

	//declaration
	S_Signature_MiniJava x_2 = new S_Signature_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_11(x_2);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_11(x_2);
  }
  private void regle10() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Type_MiniJava x_4 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_8 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_9 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_10(x_4, x_5, x_8);
	x_2.analyser(LEX_MiniJava.token_final);
	x_3.analyser(LEX_MiniJava.token_statique);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_identificateur);
	x_6.analyser(LEX_MiniJava.token_affectation);
if  (att_eval)	  action_tdsAtt_10(x_4, x_5, x_8);
	x_8.analyser() ;
	x_9.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_10(x_4, x_5, x_8);
  }
private void action_auto_inh_10(S_Type_MiniJava x_4, T_MiniJava x_5, S_Expression_MiniJava x_8) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_8.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_8.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_8.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_8.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_8.att_tds=this.att_tds;
x_4.att_factory=this.att_factory;
x_8.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementInterface -> final statique Type identificateur affectation #tdsAtt Expression point_virgule #ast ;", e });
}
  }
private void action_auto_inh_11(S_Signature_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_2.att_identObjetCourant=this.att_identObjetCourant;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementInterface -> Signature point_virgule #ast ;", e });
}
  }
private void action_tdsAtt_10(S_Type_MiniJava x_4, T_MiniJava x_5, S_Expression_MiniJava x_8) throws Exception {
try {
// instructions
x_8.att_tdsAtt= new SymbolTable();
x_8.att_nomClasse="notClasse";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tdsAtt","ElementInterface -> final statique Type identificateur affectation #tdsAtt Expression point_virgule #ast ;", e });
}
  }
private void action_ast_10(S_Type_MiniJava x_4, T_MiniJava x_5, S_Expression_MiniJava x_8) throws Exception {
try {
// locales
StaticField loc_stf;
// instructions
if ((this.att_tds.knows(x_5.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_field_ident_already_defined, MiniJavaMessages.field_ident_already_defined,new Object[]{""+x_5.att_txt});

}
else {
loc_stf=this.att_factory.createStaticField(x_4.att_ast, x_5.att_txt, x_8.att_ast);
loc_stf.setFinal(true);
this.att_ast=loc_stf;
this.att_tdsAttributs.register(loc_stf, this.att_identObjetCourant);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementInterface -> final statique Type identificateur affectation #tdsAtt Expression point_virgule #ast ;", e });
}
  }
private void action_ast_11(S_Signature_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
this.att_tdsMethodes.registerM(x_2.att_ast, this.att_identObjetCourant);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementInterface -> Signature point_virgule #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_final : // 102
        regle10 () ;
      break ;
      case LEX_MiniJava.token_vide : // 90
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 87
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle11 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle11 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
