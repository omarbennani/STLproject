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
public class S_Principale_MiniJava {
LEX_MiniJava scanner;
  S_Principale_MiniJava() {
	}
  S_Principale_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  MethodePrincipale att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  private void regle21() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_MethodePrincipale_MiniJava x_6 = new S_MethodePrincipale_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_21(x_4, x_6);
	x_2.analyser(LEX_MiniJava.token_public);
	x_3.analyser(LEX_MiniJava.token_classe);
	x_4.analyser(LEX_MiniJava.token_identificateur_type);
	x_5.analyser(LEX_MiniJava.token_accolade_ouvrante);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_21(x_4, x_6);
  }
private void action_auto_inh_21(T_MiniJava x_4, S_MethodePrincipale_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tds=this.att_tds;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Principale -> public classe identificateur_type accolade_ouvrante MethodePrincipale accolade_fermante #ast ;", e });
}
  }
private void action_ast_21(T_MiniJava x_4, S_MethodePrincipale_MiniJava x_6) throws Exception {
try {
// locales
MethodePrincipale loc_m;
// instructions
if (this.att_tdsClasses.contains(x_4.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_already_defined_ident, MiniJavaMessages.already_defined_ident,new Object[]{""+x_4.att_txt});

}
else if (this.att_tdsInterface.contains(x_4.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_already_defined_ident, MiniJavaMessages.already_defined_ident,new Object[]{""+x_4.att_txt});

}
else {
loc_m=x_6.att_ast;
loc_m.setIdentificateurType(x_4.att_txt);
this.att_ast=loc_m;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Principale -> public classe identificateur_type accolade_ouvrante MethodePrincipale accolade_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle21 () ;
  }
  }
