package org.jinq.jpa.transform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.metamodel.Metamodel;

import ch.epfl.labos.iu.orm.queryll2.path.TransformationClassAnalyzer;
import ch.epfl.labos.iu.orm.queryll2.symbolic.MethodSignature;

public class ScalaMetamodelUtil extends MetamodelUtil
{
   public final static MethodSignature INQUERYSTREAMSOURCE_STREAM = new MethodSignature("org/jinq/orm/stream/scala/InQueryStreamSource", "stream", "(Ljava/lang/Class;)Lorg/jinq/orm/stream/scala/JinqScalaStream;");
   public final static MethodSignature newTuple2 = new MethodSignature("scala/Tuple2", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V");
   public final static MethodSignature tuple2GetOne = new MethodSignature("scala/Tuple2", "_1", "()Ljava/lang/Object;");
   public final static MethodSignature tuple2GetTwo = new MethodSignature("scala/Tuple2", "_2", "()Ljava/lang/Object;");
   public final static MethodSignature newTuple3 = new MethodSignature("scala/Tuple3", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V");
   public final static MethodSignature tuple3GetOne = new MethodSignature("scala/Tuple3", "_1", "()Ljava/lang/Object;");
   public final static MethodSignature tuple3GetTwo = new MethodSignature("scala/Tuple3", "_2", "()Ljava/lang/Object;");
   public final static MethodSignature tuple3GetThree = new MethodSignature("scala/Tuple3", "_3", "()Ljava/lang/Object;");
   public final static MethodSignature newTuple4 = new MethodSignature("scala/Tuple4", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V");
   public final static MethodSignature tuple4GetOne = new MethodSignature("scala/Tuple4", "_1", "()Ljava/lang/Object;");
   public final static MethodSignature tuple4GetTwo = new MethodSignature("scala/Tuple4", "_2", "()Ljava/lang/Object;");
   public final static MethodSignature tuple4GetThree = new MethodSignature("scala/Tuple4", "_3", "()Ljava/lang/Object;");
   public final static MethodSignature tuple4GetFour = new MethodSignature("scala/Tuple4", "_4", "()Ljava/lang/Object;");
   public final static MethodSignature newTuple5 = new MethodSignature("scala/Tuple5", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V");
   public final static MethodSignature tuple5GetOne = new MethodSignature("scala/Tuple5", "_1", "()Ljava/lang/Object;");
   public final static MethodSignature tuple5GetTwo = new MethodSignature("scala/Tuple5", "_2", "()Ljava/lang/Object;");
   public final static MethodSignature tuple5GetThree = new MethodSignature("scala/Tuple5", "_3", "()Ljava/lang/Object;");
   public final static MethodSignature tuple5GetFour = new MethodSignature("scala/Tuple5", "_4", "()Ljava/lang/Object;");
   public final static MethodSignature tuple5GetFive = new MethodSignature("scala/Tuple5", "_5", "()Ljava/lang/Object;");
   public final static MethodSignature newTuple8 = new MethodSignature("scala/Tuple8", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V");
   public final static MethodSignature tuple8GetOne = new MethodSignature("scala/Tuple8", "_1", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetTwo = new MethodSignature("scala/Tuple8", "_2", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetThree = new MethodSignature("scala/Tuple8", "_3", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetFour = new MethodSignature("scala/Tuple8", "_4", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetFive = new MethodSignature("scala/Tuple8", "_5", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetSix = new MethodSignature("scala/Tuple8", "_6", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetSeven = new MethodSignature("scala/Tuple8", "_7", "()Ljava/lang/Object;");
   public final static MethodSignature tuple8GetEight = new MethodSignature("scala/Tuple8", "_8", "()Ljava/lang/Object;");

   public static final Map<MethodSignature, Integer> TUPLE_ACCESSORS = new HashMap<>();
   static {
      TUPLE_ACCESSORS.put(tuple2GetOne, 1);
      TUPLE_ACCESSORS.put(tuple2GetTwo, 2);
      TUPLE_ACCESSORS.put(tuple3GetOne, 1);
      TUPLE_ACCESSORS.put(tuple3GetTwo, 2);
      TUPLE_ACCESSORS.put(tuple3GetThree, 3);
      TUPLE_ACCESSORS.put(tuple4GetOne, 1);
      TUPLE_ACCESSORS.put(tuple4GetTwo, 2);
      TUPLE_ACCESSORS.put(tuple4GetThree, 3);
      TUPLE_ACCESSORS.put(tuple4GetFour, 4);
      TUPLE_ACCESSORS.put(tuple5GetOne, 1);
      TUPLE_ACCESSORS.put(tuple5GetTwo, 2);
      TUPLE_ACCESSORS.put(tuple5GetThree, 3);
      TUPLE_ACCESSORS.put(tuple5GetFour, 4);
      TUPLE_ACCESSORS.put(tuple5GetFive, 5);
      TUPLE_ACCESSORS.put(tuple8GetOne, 1);
      TUPLE_ACCESSORS.put(tuple8GetTwo, 2);
      TUPLE_ACCESSORS.put(tuple8GetThree, 3);
      TUPLE_ACCESSORS.put(tuple8GetFour, 4);
      TUPLE_ACCESSORS.put(tuple8GetFive, 5);
      TUPLE_ACCESSORS.put(tuple8GetSix, 6);
      TUPLE_ACCESSORS.put(tuple8GetSeven, 7);
      TUPLE_ACCESSORS.put(tuple8GetEight, 8);
   }
   
   static Set<MethodSignature> KnownSafeMethods = new HashSet<>();
   static {
      KnownSafeMethods.addAll(TUPLE_ACCESSORS.keySet());
      KnownSafeMethods.add(INQUERYSTREAMSOURCE_STREAM);
   }
   
   private Set<MethodSignature> safeMethods;
   private Set<MethodSignature> oldSafeMethods = null;

   public ScalaMetamodelUtil(Metamodel metamodel)
   {
      super(metamodel);
   }

   private void calculateScalaSafeMethods(Set<MethodSignature> javaSafeMethods)
   {
      Set<MethodSignature> newSafeMethods = new HashSet<>();
      newSafeMethods.addAll(javaSafeMethods);
      newSafeMethods.addAll(KnownSafeMethods);
      safeMethods = newSafeMethods;
      oldSafeMethods = javaSafeMethods;
   }

   @Override
   public Set<MethodSignature> getSafeMethods()
   {
      Set<MethodSignature> superSafeMethods = super.getSafeMethods();
      if (superSafeMethods == oldSafeMethods)
         return safeMethods;
      calculateScalaSafeMethods(superSafeMethods);
      return safeMethods;
   }
}