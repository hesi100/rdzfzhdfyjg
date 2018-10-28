package hesi100.com.nihss;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesi100 on 5/24/2018.
 */

public class Answer {
    static int []sum=new int[16];

    public static List<String> getAnswer(int x)
    {
        sum[x]=0;
        List<String> answer=new ArrayList<>();
        switch (x)
        {
            case 0:
            {
                answer.clear();
                answer.add(0,"Alert ; keenly responsive");
                answer.add(1,"Not alert; but arousable by minor stimulation to obey, answer, or respond");
                answer.add(2,"Not alert; only responsive to repeated or strong or painful stimulation");
                answer.add(3,"Responds only with reflex motor or autonomic effects, or totally unresponsive, flaccid, and areflexic.");
                answer.add(4,"null");
                return answer;
            }
            case 1:
            {
                answer.clear();
                answer.add(0,"Answers both questions correctly");
                answer.add(1,"Answers one question correctly.");
                answer.add(2,"Answers neither question correctly");
                answer.add(3,"null");
                return answer;
            }
            case 2:
            {
                answer.clear();
                answer.add(0,"Performs both tasks correctly");
                answer.add(1,"Performs one task correctly");
                answer.add(2,"Performs neither task correctly");
                answer.add(3,"null");
                return answer;
            }
            case 3:
            {
                answer.clear();
                answer.add(0,"Normal");
                answer.add(1,"Partial gaze palsy; gaze is abnormal in one or both eyes, but forced deviation or total gaze paresis is not present");
                answer.add(2,"Forced deviation, or total gaze paresis is not overcome by the oculocephalic maneuver");
                answer.add(3,"null");
                return answer;
            }
            case 4:
            {
                answer.clear();
                answer.add(0,"No visual loss");
                answer.add(1,"Partial hemianopia");
                answer.add(2,"Complete hemianopia");
                answer.add(3,"Bilateral hemianopia (blind including cortical blindness)");
                answer.add(4,"null");
                return answer;
            }
            case 5:
            {
                answer.clear();
                answer.add(0,"Normal symmetrical movements");
                answer.add(1,"Minor paralysis (flattened nasolabial fold, asymmetry on smiling)");
                answer.add(2,"Partial paralysis (total or near-total paralysis of lower face)");
                answer.add(3,"Complete paralysis of one or both sides (absence of facial movement in the upper and lower face)");
                answer.add(4,"null");
                return answer;
            }
            case 6:
            {
                answer.clear();
                answer.add(0,"No drift; limb holds 90 (or 45) degrees for full 10 seconds");
                answer.add(1,"Drift; limb holds 90 (or 45) degrees, but drifts down before full 10 seconds; does not hit bed or other support");
                answer.add(2,"Some effort against gravity; limb cannot get to or maintain (if cued) 90 (or 45) degrees, drifts down");
                answer.add(3,"No effort against gravity; limb falls");
                answer.add(4,"No movement");
                answer.add(5,"null");
                answer.add(6,"null");
                answer.add(7,"Amputation or joint fusion");
                return answer;
            }
            case 7:
            {
                answer.clear();
                answer.add(0,"No drift; limb holds 90 (or 45) degrees for full 10 seconds");
                answer.add(1,"Drift; limb holds 90 (or 45) degrees, but drifts down before full 10 seconds; does not hit bed or other support");
                answer.add(2,"Some effort against gravity; limb cannot get to or maintain (if cued) 90 (or 45) degrees, drifts down");
                answer.add(3,"No effort against gravity; limb falls");
                answer.add(4,"No movement");
                answer.add(5,"null");
                answer.add(6,"null");
                answer.add(7,"Amputation or joint fusion");
                return answer;
            }
            case 8:
            {
                answer.clear();
                answer.add(0,"No drift; leg holds 30-degree position for full 5 seconds");
                answer.add(1,"Drift; leg falls by the end of the 5- second period but does not hit the bed");
                answer.add(2,"Some effort against gravity; leg falls to bed by 5 seconds but has some effort against gravity");
                answer.add(3,"No effort against gravity; leg falls to bed immediately");
                answer.add(4,"No movement");
                answer.add(5,"null");
                answer.add(6,"null");
                answer.add(7,"Amputation or joint fusion");
                return answer;
            }
            case 9:
            {
                answer.clear();
                answer.add(0,"No drift; leg holds 30-degree position for full 5 seconds");
                answer.add(1,"Drift; leg falls by the end of the 5- second period but does not hit the bed");
                answer.add(2,"Some effort against gravity; leg falls to bed by 5 seconds but has some effort against gravity");
                answer.add(3,"No effort against gravity; leg falls to bed immediately");
                answer.add(4,"No movement");
                answer.add(5,"null");
                answer.add(6,"null");
                answer.add(7,"Amputation or joint fusion");
                return answer;
            }
            case 10:
            {
                answer.clear();
                answer.add(0,"Absent");
                answer.add(1,"Present in one limb");
                answer.add(2,"Present in two limbs");
                answer.add(3,"null");
                answer.add(4,"null");
                answer.add(5,"null");
                answer.add(6,"null");
                answer.add(7,"Amputation or joint fusion");
                return answer;
            }
            case 11:
            {
                answer.clear();
                answer.add(0,"Normal; no sensory loss");
                answer.add(1,"Mild-to-moderate sensory loss; patient feels pinprick is less sharp or is dull on the affected side");
                answer.add(2,"Severe or total sensory loss; patient is not aware of being touched in the face, arm, and leg");
                answer.add(3,"null");
                return answer;
            }
            case 12:
            {
                answer.clear();
                answer.add(0,"No aphasia; normal");
                answer.add(1,"Mild-to-moderate aphasia; some obvious loss of fluency or facility of comprehension, without significant limitation on ideas expressed or form of expression. Reduction of speech and/or comprehension, however, makes conversation about provided materials difficult or impossible");
                answer.add(2,"Severe aphasia; all communication is through fragmentary expression. Examiner cannot identify materials provided from patient response.");
                answer.add(3,"Mute, global aphasia; no usable speech or auditory comprehension");
                answer.add(4,"null");
                return answer;
            }
            case 13:
            {
                answer.clear();
                answer.add(0,"Normal");
                answer.add(1,"Mild-to-moderate dysarthria; patient slurs at least some words and, at worst, can be understood with some difficulty.");
                answer.add(2,"Severe dysarthria; patient's speech is so slurred as to be unintelligible in the absence of or out of proportion to any dysphasia, or is mute/anarthric.");
                answer.add(3,"null");
                answer.add(4,"null");
                answer.add(5,"null");
                answer.add(6,"null");
                answer.add(7,"Intubated or other physical barrier");
                return answer;
            }
            case 14:
            {
                answer.clear();
                answer.add(0, "No abnormality");
                answer.add(1, "Visual, tactile, auditory, spatial, or personal inattention, or extinction to bilateral simultaneous stimulation in one of the sensory modalities");
                answer.add(2, "Profound hemi-inattention or extinction to more than one modality; does not recognize own hand or orients to only one side of space");
                answer.add(3,"null");
                return answer;

            }
        }
        return answer;
    }
    public static String title(int x)
    {
        String t = null;
        switch (x)
        {
            case 0:
                t="Level of consciousness (LOC):";
                return t;
            case 1:
                t="LOC Questions:";
                return t;
            case 2:
                t="LOC Commands:";
                return t;
            case 3:
                t="Best Gaze:";
                return t;
            case 4:
                t="Visual (Test Visual fields):";
                return t;
            case 5:
                t="Facial Palsy:";
                return t;
            case 6:
                t="Motor Arm right:";
                return t;
            case 7:
                t="Motor Arm left:";
                return t;
            case 8:
                t="Motor leg right:";
                return t;
            case 9:
                t="Motor leg left:";
                return t;
            case 10:
                t="Limb Ataxia:";
                return t;
            case 11:
                t="Sensory:";
                return t;
            case 12:
                t="Best Language:";
                return t;
            case 13:
                t="Dysarthria:";
                return t;
            case 14:
                t="Extinction and Inattention (formerly Neglect):";
                return t;
            case 15:
                t="Help";
                return t;
        }
        return t;
    }
    public static String gethelp(int x)
    {
        String t = null;
        switch (x)
        {
            case 0:
                t="The investigator must choos response, even if a full evaluation is prevented by such obstacles as an endotracheal tube, e a language barrier, orotracheal trauma/bandages. A \"3\" is scored only if the patient makes no movement (other than reflexive posturing) in response to noxious stimulation.";
                return t;
            case 1:
                t="The patient is asked the month and his/her age. The answer must be correct - there is no partial credit for being close. Aphasic and stuporous patients who do not comprehend the questions will score 2. Patients unable to speak because of endotracheal intubation, orotracheal trauma, severe dysarthria from any cause, language barrier, or any other problem not secondary to aphasia are given a 1. It is important that only the initial answer be graded and that the examiner not \"help\" the patient with verbal or non-verbal cues.";
                return t;
            case 2:
                t="The patient is asked to open and close the eyes and then to grip and release the non-paretic hand. Substitute another one-step command if the hands cannot be used. Credit is given if an unequivocal attempt is made but not completed due to weakness. If the patient does not respond to command, the task should be demonstrated to him or her (pantomime), and the result scored (i.e., follows none, one, or two commands). Patients with trauma, amputation, or other physical impediments should be given suitable one-step commands. Only the first attempt is scored.";
                return t;
            case 3:
                t="Only horizontal eye movements will be tested. Voluntary or reflexive (oculocephalic) eye movements will be scored, but caloric testing is not done. If the patient has a conjugate deviation of the eyes that can be overcome by voluntary or reflexive activity, the score will be 1. If a patient has an isolated peripheral nerve paresis (CN III, IV, or VI), score a 1. Gaze is testable in all aphasic patients. Patients with ocular trauma, bandages, pre-existing blindness, or other disorder of visual acuity or fields should be tested with reflexive movements, and a choice made by the investigator. Establishing eye contact and then moving about the patient from side to side will occasionally clarify the presence of a partial gaze palsy.";
                return t;
            case 4:
                t="Visual fields (upper and lower quadrants) are tested by confrontation, using finger counting or visual threat, as appropriate. Patients may be encouraged, but if they look at the side of the moving fingers appropriately, this can be scored as normal. If there is unilateral blindness or enucleation, visual fields in the remaining eye are scored. Score 1 only if a clear-cut asymmetry, including quadrantanopia, is found. If patient is blind from any cause, score 3. Double simultaneous stimulation is performed at this point. If there is extinction, patient receives a 1, and the results are used to respond to item 11.";
                return t;
            case 5:
                t="Ask or use pantomime to encourage the patient to show teeth or raise eyebrows and close eyes. Score symmetry of grimace in response to noxious stimuli in the poorly responsive or non-comprehending patient. If facial trauma/bandages, orotracheal tube, tape, or other physical barriers obscure the face, these should be removed to the extent possible.";
                return t;
            case 6:
                t="The limb is placed in the appropriate position: extend the arms (palms down) 90 degrees (if sitting) or 45 degrees (if supine). Drift is scored if the arm falls before 10 seconds. The aphasic patient is encouraged using urgency in the voice and pantomime, but not noxious stimulation. Each limb is tested in turn, beginning with the non-paretic arm. Only in the case of amputation or joint fusion at the shoulder, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice.";
                return t;
            case 7:
                t="The limb is placed in the appropriate position: extend the arms (palms down) 90 degrees (if sitting) or 45 degrees (if supine). Drift is scored if the arm falls before 10 seconds. The aphasic patient is encouraged using urgency in the voice and pantomime, but not noxious stimulation. Each limb is tested in turn, beginning with the non-paretic arm. Only in the case of amputation or joint fusion at the shoulder, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice.";
                return t;
            case 8:
                t="The limb is placed in the appropriate position: hold the leg at 30 degrees (always tested supine). Drift is scored if the leg falls before 5 seconds. The aphasic patient is encouraged using urgency in the voice and pantomime but not noxious stimulation. Each limb is tested in turn, beginning with the non-paretic leg. Only in the case of amputation or joint fusion at the hip, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice.";
                return t;
            case 9:
                t="The limb is placed in the appropriate position: hold the leg at 30 degrees (always tested supine). Drift is scored if the leg falls before 5 seconds. The aphasic patient is encouraged using urgency in the voice and pantomime but not noxious stimulation. Each limb is tested in turn, beginning with the non-paretic leg. Only in the case of amputation or joint fusion at the hip, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice.";
                return t;
            case 10:
                t="This item is aimed at finding evidence of a unilateral cerebellar lesion. Test with eyes open. In case of visual defect, ensure testing is done in intact visual field. The fingernose- finger and heel-shin tests are performed on both sides, and ataxia is scored only if present out of proportion to weakness. Ataxia is absent in the patient who cannot understand or is paralyzed. Only in the case of amputation or joint fusion, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice. In case of blindness, test by having the patient touch nose from extended arm position.";
                return t;
            case 11:
                t="Sensation or grimace to pinprick when tested, or withdrawal from noxious stimulus in the obtunded or aphasic patient. Only sensory loss attributed to stroke is scored as abnormal and the examiner should test as many body areas [arms (not hands), legs, trunk, face] as needed to accurately check for hemisensory loss. A score of 2, \"severe or total sensory loss,\" should only be given when a severe or total loss of sensation can be clearly demonstrated. Stuporous and aphasic patients will, therefore, probably score 1 or 0. The patient with brainstem stroke who has bilateral loss of sensation is scored 2. If the patient does not respond and is quadriplegic, score 2. Patients in a coma (item 1a=3) are automatically given a 2 on this item.";
                return t;
            case 12:
                t="A great deal of information about comprehension will be obtained during the preceding sections of the examination. For this scale item, the patient is asked to describe what is happening in the attached picture, to name the items on the attached naming sheet, and to read from the attached list of sentences. Comprehension is judged from responses here, as well as to all of the commands in the preceding general neurological exam. If visual loss interferes with the tests, ask the patient to identify objects placed in the hand, repeat, and produce speech. The intubated patient should be asked to write. The patient in a coma (item 1a=3) will automatically score 3 on this item. The examiner must choose a score for the patient with stupor or limited cooperation, but a score of 3 should be used only if the patient is mute and follows no one-step commands.";
                return t;
            case 13:
                t="If patient is thought to be normal, an adequate sample of speech must be obtained by asking patient to read or repeat words from the NIH Stroke Scale document pages 6 and 8 (pdf, 495kb). If the patient has severe aphasia, the clarity of articulation of spontaneous speech can be rated. Only if the patient is intubated or has other physical barriers to producing speech, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice. Do not tell the patient why he/she is being tested.";
                return t;
            case 14:
                t="Sufficient information to identify neglect may be obtained during the prior testing. If the patient has a severe visual loss preventing visual double simultaneous stimulation, and the cutaneous stimuli are normal, the score is normal. If the patient has aphasia but does appear to attend to both sides, the score is normal. The presence of visual spatial neglect or anosagnosia may also be taken as evidence of abnormality. Since the abnormality is scored only if present, the item is never untestable.";
                return t;
            case 15:
                t="Todays, the increasing developments achieved in therapeutic methods and early investigation of patients’ problems and consequently decrease in final mortality rate have resulted in early initiation of patients’ evaluation and treatment even before the hospital arrival and their continuation after admission and hospitalization. This mobile-based application guide the health care providers in assessing the severity and choosing the appropriate therapeutic trend for acute stroke patient, Therefore, it can lead to reduction of medical errors, improvement of treatment process and quality of care.";
                return t;
        }
        return t;
    }
    public static void setsum(int x,int s)
    {
        sum[x]=s;
    }
    public static int getsum(int x)
    {
        return sum[x];
    }

}