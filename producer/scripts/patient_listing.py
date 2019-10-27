
import mysql.connector

cnx = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="",
    database="ds_assignment1")

cur = cnx.cursor()


def get_all_patients():
    # Execute a query
    cur.execute("SELECT id from patient")

    # Fetch results
    results = cur.fetchall()

    patients_id = [patient[0] for patient in results]


    return patients_id


if __name__ == "__main__":
    patients = get_all_patients()
    print(patients)