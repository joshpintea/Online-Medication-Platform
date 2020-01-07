
package views.core.soap_web_services;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the views.core.soap_web_services package. 
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

    private final static QName _MedicationPlanNotObeyed_QNAME = new QName("soap_web_services.core.views", "MedicationPlanNotObeyed");
    private final static QName _MedicationPlanNotObeyedArray_QNAME = new QName("soap_web_services.core.views", "MedicationPlanNotObeyedArray");
    private final static QName _ActivityModel_QNAME = new QName("soap_web_services.core.views", "ActivityModel");
    private final static QName _MedicationPlanModel_QNAME = new QName("soap_web_services.core.views", "MedicationPlanModel");
    private final static QName _MedicationPlanIntervalModelArray_QNAME = new QName("soap_web_services.core.views", "MedicationPlanIntervalModelArray");
    private final static QName _ActivityModelArray_QNAME = new QName("soap_web_services.core.views", "ActivityModelArray");
    private final static QName _MedicationPlanIntervalModel_QNAME = new QName("soap_web_services.core.views", "MedicationPlanIntervalModel");
    private final static QName _MedicationPlanModelStartDate_QNAME = new QName("soap_web_services.core.views", "start_date");
    private final static QName _MedicationPlanModelIntakeIntervalPeriod_QNAME = new QName("soap_web_services.core.views", "intake_interval_period");
    private final static QName _MedicationPlanModelDoctorId_QNAME = new QName("soap_web_services.core.views", "doctor_id");
    private final static QName _MedicationPlanModelEndDate_QNAME = new QName("soap_web_services.core.views", "end_date");
    private final static QName _MedicationPlanModelPatientId_QNAME = new QName("soap_web_services.core.views", "patient_id");
    private final static QName _MedicationPlanNotObeyedMedicationPlan_QNAME = new QName("soap_web_services.core.views", "medication_plan");
    private final static QName _MedicationPlanNotObeyedIntakeIntervals_QNAME = new QName("soap_web_services.core.views", "intake_intervals");
    private final static QName _MedicationPlanIntervalModelIntakeIntervalStart_QNAME = new QName("soap_web_services.core.views", "intake_interval_start");
    private final static QName _MedicationPlanIntervalModelDay_QNAME = new QName("soap_web_services.core.views", "day");
    private final static QName _MedicationPlanIntervalModelMedicationPlanId_QNAME = new QName("soap_web_services.core.views", "medication_plan_id");
    private final static QName _MedicationPlanIntervalModelIntakeIntervalEnd_QNAME = new QName("soap_web_services.core.views", "intake_interval_end");
    private final static QName _MedicationPlanIntervalModelTakenOnTime_QNAME = new QName("soap_web_services.core.views", "taken_on_time");
    private final static QName _MedicationPlanIntervalModelHour_QNAME = new QName("soap_web_services.core.views", "hour");
    private final static QName _ActivityModelActivityLavel_QNAME = new QName("soap_web_services.core.views", "activity_lavel");
    private final static QName _ActivityModelIsNormal_QNAME = new QName("soap_web_services.core.views", "is_normal");
    private final static QName _ActivityModelIsViolated_QNAME = new QName("soap_web_services.core.views", "is_violated");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: views.core.soap_web_services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MedicationPlanNotObeyed }
     * 
     */
    public MedicationPlanNotObeyed createMedicationPlanNotObeyed() {
        return new MedicationPlanNotObeyed();
    }

    /**
     * Create an instance of {@link MedicationPlanNotObeyedArray }
     * 
     */
    public MedicationPlanNotObeyedArray createMedicationPlanNotObeyedArray() {
        return new MedicationPlanNotObeyedArray();
    }

    /**
     * Create an instance of {@link ActivityModel }
     * 
     */
    public ActivityModel createActivityModel() {
        return new ActivityModel();
    }

    /**
     * Create an instance of {@link MedicationPlanModel }
     * 
     */
    public MedicationPlanModel createMedicationPlanModel() {
        return new MedicationPlanModel();
    }

    /**
     * Create an instance of {@link ActivityModelArray }
     * 
     */
    public ActivityModelArray createActivityModelArray() {
        return new ActivityModelArray();
    }

    /**
     * Create an instance of {@link MedicationPlanIntervalModelArray }
     * 
     */
    public MedicationPlanIntervalModelArray createMedicationPlanIntervalModelArray() {
        return new MedicationPlanIntervalModelArray();
    }

    /**
     * Create an instance of {@link MedicationPlanIntervalModel }
     * 
     */
    public MedicationPlanIntervalModel createMedicationPlanIntervalModel() {
        return new MedicationPlanIntervalModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanNotObeyed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "MedicationPlanNotObeyed")
    public JAXBElement<MedicationPlanNotObeyed> createMedicationPlanNotObeyed(MedicationPlanNotObeyed value) {
        return new JAXBElement<MedicationPlanNotObeyed>(_MedicationPlanNotObeyed_QNAME, MedicationPlanNotObeyed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanNotObeyedArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "MedicationPlanNotObeyedArray")
    public JAXBElement<MedicationPlanNotObeyedArray> createMedicationPlanNotObeyedArray(MedicationPlanNotObeyedArray value) {
        return new JAXBElement<MedicationPlanNotObeyedArray>(_MedicationPlanNotObeyedArray_QNAME, MedicationPlanNotObeyedArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "ActivityModel")
    public JAXBElement<ActivityModel> createActivityModel(ActivityModel value) {
        return new JAXBElement<ActivityModel>(_ActivityModel_QNAME, ActivityModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "MedicationPlanModel")
    public JAXBElement<MedicationPlanModel> createMedicationPlanModel(MedicationPlanModel value) {
        return new JAXBElement<MedicationPlanModel>(_MedicationPlanModel_QNAME, MedicationPlanModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanIntervalModelArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "MedicationPlanIntervalModelArray")
    public JAXBElement<MedicationPlanIntervalModelArray> createMedicationPlanIntervalModelArray(MedicationPlanIntervalModelArray value) {
        return new JAXBElement<MedicationPlanIntervalModelArray>(_MedicationPlanIntervalModelArray_QNAME, MedicationPlanIntervalModelArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityModelArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "ActivityModelArray")
    public JAXBElement<ActivityModelArray> createActivityModelArray(ActivityModelArray value) {
        return new JAXBElement<ActivityModelArray>(_ActivityModelArray_QNAME, ActivityModelArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanIntervalModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "MedicationPlanIntervalModel")
    public JAXBElement<MedicationPlanIntervalModel> createMedicationPlanIntervalModel(MedicationPlanIntervalModel value) {
        return new JAXBElement<MedicationPlanIntervalModel>(_MedicationPlanIntervalModel_QNAME, MedicationPlanIntervalModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "start_date", scope = MedicationPlanModel.class)
    public JAXBElement<XMLGregorianCalendar> createMedicationPlanModelStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MedicationPlanModelStartDate_QNAME, XMLGregorianCalendar.class, MedicationPlanModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "intake_interval_period", scope = MedicationPlanModel.class)
    public JAXBElement<BigInteger> createMedicationPlanModelIntakeIntervalPeriod(BigInteger value) {
        return new JAXBElement<BigInteger>(_MedicationPlanModelIntakeIntervalPeriod_QNAME, BigInteger.class, MedicationPlanModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "doctor_id", scope = MedicationPlanModel.class)
    public JAXBElement<Long> createMedicationPlanModelDoctorId(Long value) {
        return new JAXBElement<Long>(_MedicationPlanModelDoctorId_QNAME, Long.class, MedicationPlanModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "end_date", scope = MedicationPlanModel.class)
    public JAXBElement<XMLGregorianCalendar> createMedicationPlanModelEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MedicationPlanModelEndDate_QNAME, XMLGregorianCalendar.class, MedicationPlanModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "patient_id", scope = MedicationPlanModel.class)
    public JAXBElement<Long> createMedicationPlanModelPatientId(Long value) {
        return new JAXBElement<Long>(_MedicationPlanModelPatientId_QNAME, Long.class, MedicationPlanModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "medication_plan", scope = MedicationPlanNotObeyed.class)
    public JAXBElement<MedicationPlanModel> createMedicationPlanNotObeyedMedicationPlan(MedicationPlanModel value) {
        return new JAXBElement<MedicationPlanModel>(_MedicationPlanNotObeyedMedicationPlan_QNAME, MedicationPlanModel.class, MedicationPlanNotObeyed.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicationPlanIntervalModelArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "intake_intervals", scope = MedicationPlanNotObeyed.class)
    public JAXBElement<MedicationPlanIntervalModelArray> createMedicationPlanNotObeyedIntakeIntervals(MedicationPlanIntervalModelArray value) {
        return new JAXBElement<MedicationPlanIntervalModelArray>(_MedicationPlanNotObeyedIntakeIntervals_QNAME, MedicationPlanIntervalModelArray.class, MedicationPlanNotObeyed.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "intake_interval_start", scope = MedicationPlanIntervalModel.class)
    public JAXBElement<BigInteger> createMedicationPlanIntervalModelIntakeIntervalStart(BigInteger value) {
        return new JAXBElement<BigInteger>(_MedicationPlanIntervalModelIntakeIntervalStart_QNAME, BigInteger.class, MedicationPlanIntervalModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "day", scope = MedicationPlanIntervalModel.class)
    public JAXBElement<XMLGregorianCalendar> createMedicationPlanIntervalModelDay(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MedicationPlanIntervalModelDay_QNAME, XMLGregorianCalendar.class, MedicationPlanIntervalModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "medication_plan_id", scope = MedicationPlanIntervalModel.class)
    public JAXBElement<Long> createMedicationPlanIntervalModelMedicationPlanId(Long value) {
        return new JAXBElement<Long>(_MedicationPlanIntervalModelMedicationPlanId_QNAME, Long.class, MedicationPlanIntervalModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "intake_interval_end", scope = MedicationPlanIntervalModel.class)
    public JAXBElement<BigInteger> createMedicationPlanIntervalModelIntakeIntervalEnd(BigInteger value) {
        return new JAXBElement<BigInteger>(_MedicationPlanIntervalModelIntakeIntervalEnd_QNAME, BigInteger.class, MedicationPlanIntervalModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "taken_on_time", scope = MedicationPlanIntervalModel.class)
    public JAXBElement<Boolean> createMedicationPlanIntervalModelTakenOnTime(Boolean value) {
        return new JAXBElement<Boolean>(_MedicationPlanIntervalModelTakenOnTime_QNAME, Boolean.class, MedicationPlanIntervalModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "hour", scope = MedicationPlanIntervalModel.class)
    public JAXBElement<BigInteger> createMedicationPlanIntervalModelHour(BigInteger value) {
        return new JAXBElement<BigInteger>(_MedicationPlanIntervalModelHour_QNAME, BigInteger.class, MedicationPlanIntervalModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "activity_lavel", scope = ActivityModel.class)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createActivityModelActivityLavel(String value) {
        return new JAXBElement<String>(_ActivityModelActivityLavel_QNAME, String.class, ActivityModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "start_date", scope = ActivityModel.class)
    public JAXBElement<XMLGregorianCalendar> createActivityModelStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MedicationPlanModelStartDate_QNAME, XMLGregorianCalendar.class, ActivityModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "end_date", scope = ActivityModel.class)
    public JAXBElement<XMLGregorianCalendar> createActivityModelEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MedicationPlanModelEndDate_QNAME, XMLGregorianCalendar.class, ActivityModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "is_normal", scope = ActivityModel.class)
    public JAXBElement<Boolean> createActivityModelIsNormal(Boolean value) {
        return new JAXBElement<Boolean>(_ActivityModelIsNormal_QNAME, Boolean.class, ActivityModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "is_violated", scope = ActivityModel.class)
    public JAXBElement<Boolean> createActivityModelIsViolated(Boolean value) {
        return new JAXBElement<Boolean>(_ActivityModelIsViolated_QNAME, Boolean.class, ActivityModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_web_services.core.views", name = "patient_id", scope = ActivityModel.class)
    public JAXBElement<Long> createActivityModelPatientId(Long value) {
        return new JAXBElement<Long>(_MedicationPlanModelPatientId_QNAME, Long.class, ActivityModel.class, value);
    }

}
