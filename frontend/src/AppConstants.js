

const ApiRoutes = function () {
    this.host = "localhost";
    this.port = 8088;
    this.baseUrl = 'http://' + this.host + ':' + this.port + '/app';
    this.loginUrl = this.baseUrl + '/oauth/token';
    this.doctorUrl = this.baseUrl + "/api/doctor";
    this.createMedicationPlan = this.doctorUrl + "/medication";
    this.patientUrl = this.baseUrl + "/api/patient";
    this.getMedicationPlanForPatientUrl = this.patientUrl + "/medications/";
    this.caregiverUrl = this.baseUrl + "/api/caregiver";
    this.getCaregiverPatientsUrl = this.caregiverUrl + "/patients/";
    this.drugUrl = this.baseUrl + "/api/drug";
    this.userUrl = this.baseUrl + "/api/user";
    this.loggedUserUrl = this.userUrl + "/logged";

    this.sideEffectUrl = this.baseUrl + "/api/side_effect"
};

const AppRoutes = function () {
    this.login = "/login";
    this.doctorBaseUrl = "/doctor";
    this.patientBaseUrl = "/patient";
    this.caregiverBaseUrl = "/caregiver";
    this.doctorDashboard = "/doctor/";
    this.patientCrudUrl = this.doctorDashboard + "crud/patient";
    this.drugCrudUrl = this.doctorDashboard + "crud/drug";
    this.caregiverCrudUrl = this.doctorDashboard + "crud/caregiver";
    this.sideEffectCrudUrl = this.doctorDashboard + "crud/side_effect";
};


export const constants = {
    routes: {
        api : new ApiRoutes(),
        app: new AppRoutes()
    },
    loggedUser: "loggedUser",
    savedToken: "savedToken"
};