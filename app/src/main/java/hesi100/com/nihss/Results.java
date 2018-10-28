package hesi100.com.nihss;

/**
 * Created by hesi100 on 5/29/2018.
 */

public class Results {
    static Result r;
    public static Result getResult(int s)
    {
        switch (s)
        {
            case 1:
                r= new Result("1)Treatment with blood anticoagulant agents \n Or \n 2) transferring the patient to the operating room and surgery","red");
                return r;
            case 2:
                r=new Result("Thrombectomy","red");
                return r;
            case 3:
                r=new Result("Traditional treatments include:\n1) Oral or intravenous treatment of aspirin or Aspirin with Plavix or Atorvastatin\n2) If the neurologist's opinion agrees to the Fibrinolytic therapy, Fibrinolytic therapy (tPA) can be used","yellow");
                return r;
            case 4:
                r=new Result("Traditional treatments include:\nOral or intravenous treatment of aspirin or Aspirin with Plavix or Atorvastatin (Fibrinolytic therapy should not be used)","red");
                return r;
            case 5:
                r=new Result("Fibrinolytic therapy (tPA)","green");
                return r;
            default:
                r= new Result("1)Treatment with blood anticoagulant agents /n Or /n 2)2) transferring the patient to the operating room and surgery","red");
                return r;
        }

    }
}
