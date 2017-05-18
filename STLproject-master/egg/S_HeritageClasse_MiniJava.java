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
public class S_HeritageClasse_MiniJava {
LEX_MiniJava scanner;
  S_HeritageClasse_MiniJava() {
	}
  S_HeritageClasse_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Classe> att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  private void regle18() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_18();
  }
  private void regle17() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_extension);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
if  (att_eval)	  action_ast_17(x_3);
  }
private void action_ast_17(T_MiniJava x_3) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
LinkedList<Classe> loc_l;
// instructions
loc_l= new LinkedList<Classe>();
if (this.att_tdsClasses.contains(x_3.att_txt)){
loc_f=this.att_tdsClasses.get(x_3.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof Classe ){
loc_l.add(((Classe)loc_d));
}

this.att_ast=loc_l;
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_CLASS_undefined_ident, MiniJavaMessages.CLASS_undefined_ident,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","HeritageClasse -> extension identificateur_type #ast ;", e });
}
  }
private void action_ast_18() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Classe>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","HeritageClasse -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_extension : // 96
        regle17 () ;
      break ;
      case LEX_MiniJava.token_implantation : // 97
        regle18 () ;
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 53
        regle18 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
