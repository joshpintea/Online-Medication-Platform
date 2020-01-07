
package core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import views.core.soap_web_services.ActivityModel;
import views.core.soap_web_services.ActivityModelArray;
import views.core.soap_web_services.MedicationPlanNotObeyedArray;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the core.soap_web_services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetNotObeyedMedicationPlan_QNAME = new QName("soap_web_services.core", "get_not_obeyed_medication_plan");
    private final static QName _GetActivitiesByPatientIdResponse_QNAME = new QName("soap_web_services.core", "get_activities_by_patient_idResponse");
    private final static QName _AnnotateActivity_QNAME = new QName("soap_web_services.core", "annotate_activity");
    private final static QName _GetActivitiesByPatientId_QNAME = new QName("soap_web_services.core", "get_activities_by_patient_id");
    private final static QName _GetNotObeyedMedicationPlanResponse_QNAME = new QName("soap_web_services.core", "get_not_obeyed_medication_planResponse");
    private final static QName _AddRecommendationResponse_QNAME = new QName("soap_web_services.core", "add_recommendationResponse");
    private final static QName _AddRecommendation_QNAME = new QName("soap_web_services.core", "add_recommendation");
    private final static QName _AnnotateActivityResponse_QNAME = new QName("soap_web_services.core", "annotate_activityResponse");
    private final static QName _AddRecommendationRecommendation_QNAME = new QName("soap_web_services.core", "recommendation");
    private final static QName _AddRecommendationActivityId_QNAME = new QName("soap_web_services.core", "activity_id");
    private final static QName _AnnotateActivityLabel_QNAME = new QName("soap_web_services.core", "label");
    private final static QName _GetActivitiesByPatientIdPatientId_QNAME = new QName("soap_web_services.core", "patient_id");
    private final static QName _GetActivitiesByPatientIdDatetime_QNAME = new QName("soap_web_services.core", "datetime");
    private final static QName _AnnotateActivityResponseAnnotateActivityResult_QNAME = new QName("soap_web_services.core", "annotate_activityResult");
    private final static QName _GetActivitiesByPatientIdResponseGetActivitiesByPatientIdResult_QNAME = new QName("soap_web_services.core", "get_activities_by_patient_idResult");
    private final static QName _GetNotObeyedMedicationPlanDateTime_QNAME = new QName("soap_web_services.core", "date_time");
    private final static QName _GetNotObeyedMedicationPlanResponseGetNotObeyedMedicationPlanResult_QNAME = new QName("soap_web_services.core", "get_not_obeyed_medication_planResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: core.soap_web_services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetActivitiesByPatientId }
     * 
     */
    public GetActivitiesByPatientId createGetActivitiesByPatientId() {
        return new GetActivitiesByPatientId();
    }

    /**
     * Create an instance of {@link AnnotateActivity }
     * 
     */
    public AnnotateActivity createAnnotateActivity() {
        return new AnnotateActivity();
    }

    /**
     * Create an instance of {@link GetNotObeyedMedicationPlan }
     * 
     */
    public GetNotObeyedMedicationPlan createGetNotObeyedMedicationPlan() {
        return new GetNotObeyedMedicationPlan();
    }

    /**
     * Create an instance of {@link GetActivitiesByPatientIdResponse }
     * 
     */
    public GetActivitiesByPatientIdResponse createGetActivitiesByPatientIdResponse() {
        return new GetActivitiesByPatientIdResponse();
    }

    /**
     * Create an instance of {@link AddRecommendationResponse }
     * 
     */
    public AddRecommendationResponse createAddRecommendationResponse() {
        return new AddRecommendationResponse();
    }

    /**
     * Create an instance of {@link GetNotObeyedMedicationPlanResponse }
     * 
     */
    public GetNotObeyedMedicationPlanResponse createGetNotObeyedMedicationPlanResponse() {
        return new GetNotObeyedMedicationPlanResponse();
    }

    /**
     * Create an instance of {@link AnnotateActivityResponse }
     * 
     */
    public AnnotateActivityResponse createAnnotateActivityResponse() {
        return new AnnotateActivityResponse();
    }

    /**
     * Create an instance of {@link AddRecommendation }
     * 
     */
    public AddRecommendation createAddRecommendation() {
        return new AddRecommendation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotObeyedMedicationPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "get_not_obeyed_medication_plan")
    public JAXBElement<GetNotObeyedMedicationPlan> createGetNotObeyedMedicationPlan(GetNotObeyedMedicationPlan value) {
        return new JAXBElement<GetNotObeyedMedicationPlan>(_GetNotObeyedMedicationPlan_QNAME, GetNotObeyedMedicationPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActivitiesByPatientIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "get_activities_by_patient_idResponse")
    public JAXBElement<GetActivitiesByPatientIdResponse> createGetActivitiesByPatientIdResponse(GetActivitiesByPatientIdResponse value) {
        return new JAXBElement<GetActivitiesByPatientIdResponse>(_GetActivitiesByPatientIdResponse_QNAME, GetActivitiesByPatientIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotateActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "annotate_activity")
    public JAXBElement<AnnotateActivity> createAnnotateActivity(AnnotateActivity value) {
        return new JAXBElement<AnnotateActivity>(_AnnotateActivity_QNAME, AnnotateActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActivitiesByPatientId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "get_activities_by_patient_id")
    public JAXBElement<GetActivitiesByPatientId> createGetActivitiesByPatientId(GetActivitiesByPatientId value) {
        return new JAXBElement<GetActivitiesByPatientId>(_GetActivitiesByPatientId_QNAME, GetActivitiesByPatientId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotObeyedMedicationPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "get_not_obeyed_medication_planResponse")
    public JAXBElement<GetNotObeyedMedicationPlanResponse> createGetNotObeyedMedicationPlanResponse(GetNotObeyedMedicationPlanResponse value) {
        return new JAXBElement<GetNotObeyedMedicationPlanResponse>(_GetNotObeyedMedicationPlanResponse_QNAME, GetNotObeyedMedicationPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecommendationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "add_recommendationResponse")
    public JAXBElement<AddRecommendationResponse> createAddRecommendationResponse(AddRecommendationResponse value) {
        return new JAXBElement<AddRecommendationResponse>(_AddRecommendationResponse_QNAME, AddRecommendationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecommendation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "add_recommendation")
    public JAXBElement<AddRecommendation> createAddRecommendation(AddRecommendation value) {
        return new JAXBElement<AddRecommendation>(_AddRecommendation_QNAME, AddRecommendation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotateActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "annotate_activityResponse")
    public JAXBElement<AnnotateActivityResponse> createAnnotateActivityResponse(AnnotateActivityResponse value) {
        return new JAXBElement<AnnotateActivityResponse>(_AnnotateActivityResponse_QNAME, AnnotateActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "recommendation", scope = AddRecommendation.class)
    public JAXBElement<String> createAddRecommendationRecommendation(String value) {
        return new JAXBElement<String>(_AddRecommendationRecommendation_QNAME, String.class, AddRecommendation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "activity_id", scope = AddRecommendation.class)
    public JAXBElement<Long> createAddRecommendationActivityId(Long value) {
        return new JAXBElement<Long>(_AddRecommendationActivityId_QNAME, Long.class, AddRecommendation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "label", scope = AnnotateActivity.class)
    public JAXBElement<Boolean> createAnnotateActivityLabel(Boolean value) {
        return new JAXBElement<Boolean>(_AnnotateActivityLabel_QNAME, Boolean.class, AnnotateActivity.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "activity_id", scope = AnnotateActivity.class)
    public JAXBElement<Long> createAnnotateActivityActivityId(Long value) {
        return new JAXBElement<Long>(_AddRecommendationActivityId_QNAME, Long.class, AnnotateActivity.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "patient_id", scope = GetActivitiesByPatientId.class)
    public JAXBElement<Long> createGetActivitiesByPatientIdPatientId(Long value) {
        return new JAXBElement<Long>(_GetActivitiesByPatientIdPatientId_QNAME, Long.class, GetActivitiesByPatientId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "datetime", scope = GetActivitiesByPatientId.class)
    public JAXBElement<XMLGregorianCalendar> createGetActivitiesByPatientIdDatetime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetActivitiesByPatientIdDatetime_QNAME, XMLGregorianCalendar.class, GetActivitiesByPatientId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "annotate_activityResult", scope = AnnotateActivityResponse.class)
    public JAXBElement<ActivityModel> createAnnotateActivityResponseAnnotateActivityResult(ActivityModel value) {
        return new JAXBElement<ActivityModel>(_AnnotateActivityResponseAnnotateActivityResult_QNAME, ActivityModel.class, AnnotateActivityResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityModelArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "get_activities_by_patient_idResult", scope = GetActivitiesByPatientIdResponse.class)
    public JAXBElement<ActivityModelArray> createGetActivitiesByPatientIdResponseGetActivitiesByPatientIdResult(ActivityModelArray value) {
        return new JAXBElement<ActivityModelArray>(_GetActivitiesByPatientIdResponseGetActivitiesByPatientIdResult_QNAME, ActivityModelArray.class, GetActivitiesByPatientIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "patient_id", scope = GetNotObeyedMedicationPlan.class)
    public JAXBElement<Long> createGetNotObeyedMedicationPlanPatientId(Long value) {
        return new JAXBElement<Long>(_GetActivitiesByPatientIdPatientId_QNAME, Long.class, GetNotObeyedMedicationPlan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "date_time", scope = GetNotObeyedMedicationPlan.class)
    public JAXBElement<XMLGregorianCalendar> createGetNotObeyedMedicationPlanDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetNotObeyedMedicationPlanDateTime_QNAME, XMLGregorianCalendar.class, GetNotObeyedMedicationPlan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanNotObeyedArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core", name = "get_not_obeyed_medication_planResult", scope = GetNotObeyedMedicationPlanResponse.class)
    public JAXBElement<MedicationPlanNotObeyedArray> createGetNotObeyedMedicationPlanResponseGetNotObeyedMedicationPlanResult(MedicationPlanNotObeyedArray value) {
        return new JAXBElement<MedicationPlanNotObeyedArray>(_GetNotObeyedMedicationPlanResponseGetNotObeyedMedicationPlanResult_QNAME, MedicationPlanNotObeyedArray.class, GetNotObeyedMedicationPlanResponse.class, value);
    }

}
