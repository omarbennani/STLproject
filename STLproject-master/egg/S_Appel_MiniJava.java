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
public class S_Appel_MiniJava {
LEX_MiniJava scanner;
  S_Appel_MiniJava() {
	}
  S_Appel_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  Expression att_ast;
  String att_identificateur_type;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  boolean att_eval;
  String att_identificateur;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  String att_nomClasse;
  Expression att_support;
  private void regle92() throws Exception {

	//declaration
	S_Arguments_MiniJava x_2 = new S_Arguments_MiniJava(scanner,att_eval) ;
	S_Acces_MiniJava x_4 = new S_Acces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_92(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_inh_92(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_92(x_2, x_4);
  }
private void action_ast_92(S_Arguments_MiniJava x_2, S_Acces_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Appel -> Arguments #inh Acces #ast ;", e });
}
  }
private void action_auto_inh_92(S_Arguments_MiniJava x_2, S_Acces_MiniJava x_4) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_4.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_4.att_identificateur_type=this.att_identificateur_type;
x_4.att_identificateur=this.att_identificateur;
x_2.att_nomClasse=this.att_nomClasse;
x_4.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Appel -> Arguments #inh Acces #ast ;", e });
}
  }
private void action_inh_92(S_Arguments_MiniJava x_2, S_Acces_MiniJava x_4) throws Exception {
try {
// locales
Optional<Methode> loc_o;
Methode loc_m;
Type loc_t;
Classe loc_c;
Interface loc_i;
String loc_s;
// instructions
loc_o=null;
if ((this.att_support==null)){
loc_o=this.att_tdsMethodes.getMethode(this.att_identificateur, this.att_nomClasse, x_2.att_ast);
}
else {
loc_t=this.att_support.getTypeReel();
if (loc_t instanceof ClassTypeImpl ){
loc_c=((ClassTypeImpl)loc_t).getClasse();
loc_s=loc_c.getName();
loc_o=this.att_tdsMethodes.getMethode(this.att_identificateur, loc_s, x_2.att_ast);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_NOT_AN_OBJECT, MiniJavaMessages.NOT_AN_OBJECT,new Object[]{""+loc_t.toString()});


}
}
if (loc_o.isPresent()){
loc_m=loc_o.get();
x_4.att_support=this.att_factory.createAppel(this.att_support, loc_m, x_2.att_ast);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_UNDEFINED_METHOD_OR_SIGNATURE, MiniJavaMessages.UNDEFINED_METHOD_OR_SIGNATURE,new Object[]{""+this.att_identificateur});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Appel -> Arguments #inh Acces #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle92 () ;
  }
  }
