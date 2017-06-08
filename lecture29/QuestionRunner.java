public class QuestionRunner {
    public static void main(String[] args) {
        VariableAliasingQuestion q = new VariableAliasingQuestion();
        System.out.println(q.question());
        ReferenceAssignmentAndMutationQuestion q2 = new ReferenceAssignmentAndMutationQuestion();
        System.out.println(q2.question());
        PyretStyleVariableAliasingQuestion q3 = new PyretStyleVariableAliasingQuestion();
        System.out.println(q3.question());
        ComposeObjectsQuestion q4 = new ComposeObjectsQuestion();
        System.out.println(q4.question());
        //DynamicScopeQuestion q5 = new DynamicScopeQuestion();
        //System.out.println(q5.question());
        DynamicFieldQuestion1 q6 = new DynamicFieldQuestion1();
        System.out.println(q6.question());
        DynamicFieldQuestion2 q7 = new DynamicFieldQuestion2();
        System.out.println(q7.question());
        DynamicFieldQuestion3 q8 = new DynamicFieldQuestion3();
        System.out.println(q8.question());
        DynamicFieldQuestion4 q9 = new DynamicFieldQuestion4();
        System.out.println(q9.question());
        DynamicFieldQuestion5 q10 = new DynamicFieldQuestion5();
        System.out.println(q10.question());
    }
}
