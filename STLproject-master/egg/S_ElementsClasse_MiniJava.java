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
public class S_ElementsClasse_MiniJava {
LEX_MiniJava scanner;
  S_ElementsClasse_MiniJava() {
	}
  S_ElementsClasse_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<ElementClasse> att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  String att_nomClasse;
  SymbolTableMethodes att_tdsMeth;
  private void regle23() throws Exception {

	//declaration
	S_DroitAcces_MiniJava x_2 = new S_DroitAcces_MiniJava(scanner,att_eval) ;
	S_ElementClasse_MiniJava x_4 = new S_ElementClasse_MiniJava(scanner,att_eval) ;
	S_ElementsClasse_MiniJava x_5 = new S_ElementsClasse_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_23(x_2, x_4, x_5);
	x_2.analyser() ;
if  (att_eval)	  action_droit_23(x_2, x_4, x_5);
	x_4.analyser() ;
	x_5.analyser() ;
if  (att_eval)	  action_ast_23(x_2, x_4, x_5);
  }
  private void regle24() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_24();
  }
private void action_auto_inh_23(S_DroitAcces_MiniJava x_2, S_ElementClasse_MiniJava x_4, S_ElementsClasse_MiniJava x_5) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_4.att_tdsMeth=this.att_tdsMeth;
x_5.att_tdsMeth=this.att_tdsMeth;
x_4.att_tdsAtt=this.att_tdsAtt;
x_5.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_4.att_nomClasse=this.att_nomClasse;
x_5.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementsClasse -> DroitAcces #droit ElementClasse ElementsClasse1 #ast ;", e });
}
  }
private void action_droit_23(S_DroitAcces_MiniJava x_2, S_ElementClasse_MiniJava x_4, S_ElementsClasse_MiniJava x_5) throws Exception {
try {
// instructions
x_4.att_droit=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#droit","ElementsClasse -> DroitAcces #droit ElementClasse ElementsClasse1 #ast ;", e });
}
  }
private void action_ast_23(S_DroitAcces_MiniJava x_2, S_ElementClasse_MiniJava x_4, S_ElementsClasse_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_ast.addFirst(x_4.att_ast);
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementsClasse -> DroitAcces #droit ElementClasse ElementsClasse1 #ast ;", e });
}
  }
private void action_ast_24() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<ElementClasse>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementsClasse -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_public : // 98
        regle23 () ;
      break ;
      case LEX_MiniJava.token_protege : // 99
        regle23 () ;
      break ;
      case LEX_MiniJava.token_prive : // 100
        regle23 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle24 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
