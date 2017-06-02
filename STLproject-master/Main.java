import egg.*;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.SourceUnit;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.ProblemRequestor;
import java.io.*;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.impl.TAMFactoryImpl;

public class Main{

  public static void main (String[] args){
  try {
      ISourceUnit cu = new SourceUnit(args[0]);
      System.out.println("Fichier analyé : "+  args[0]);
      ProblemReporter prp = new ProblemReporter(cu);
      ProblemRequestor prq = new ProblemRequestor(true);
      MiniJava bloc = new MiniJava(prp);
      prq.beginReporting();
      bloc.set_eval(true);
      bloc.compile(cu);
      for(IProblem problem : prp.getAllProblems())
      	prq.acceptProblem(problem );
      prq.endReporting();
      System.out.println("AST :\n"+bloc.get_ast());
      if (bloc.get_ast().checkType()) 
	{
	      System.out.println( "Correctement typé." );
          bloc.get_ast().allocateMemory(Register.SB, 0);
          TAMFactory factory = new TAMFactoryImpl();
          Fragment code = bloc.get_ast().getCode(factory);
          System.out.println(code);
      } else {
	      System.out.println( "Mal typé." );
      }
      System.exit(0);
      }
    catch(Exception e){
      e.printStackTrace();
      System.exit(1);
      }
    }
}
