from django.db import models

# Create your models here.
# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey has `on_delete` set to the desired behavior.
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models
from django.utils.encoding import python_2_unicode_compatible


class User(models.Model):
    id = models.BigIntegerField(primary_key=True)
    address = models.CharField(max_length=255, blank=True, null=True)
    birth_date = models.DateField(blank=True, null=True)
    gender = models.CharField(max_length=255, blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    password = models.CharField(max_length=255, blank=True, null=True)
    role = models.CharField(max_length=255, blank=True, null=True)
    username = models.CharField(unique=True, max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'user'


@python_2_unicode_compatible
class Activity(models.Model):
    id = models.BigIntegerField(primary_key=True)
    activity_lavel = models.CharField(max_length=255, blank=True, null=True)
    end_date = models.DateTimeField(blank=True, null=True)
    start_date = models.DateTimeField(blank=True, null=True)
    patient = models.ForeignKey('Patient', models.DO_NOTHING, blank=True, null=True)
    is_violated = models.NullBooleanField(db_column='is_violated')
    is_normal = models.NullBooleanField(db_column='is_normal')

    class Meta:
        managed = False
        db_table = 'activity'

    def __str__(self):
        return '%s %s' % (self.id, self.activity_lavel)


class ActivityRecommendation(models.Model):
    id = models.AutoField(primary_key=True)
    recommendation = models.CharField(max_length=255, blank=True, null=True)
    activity = models.ForeignKey(Activity, models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'activity_recommendation'


class Caregiver(models.Model):
    id = models.ForeignKey('User', models.DO_NOTHING, db_column='id', primary_key=True)

    class Meta:
        managed = False
        db_table = 'caregiver'


class Doctor(models.Model):
    id = models.ForeignKey(User, models.DO_NOTHING, db_column='id', primary_key=True)

    class Meta:
        managed = False
        db_table = 'doctor'


class Patient(models.Model):
    id = models.ForeignKey(User, models.DO_NOTHING, db_column='id', primary_key=True)
    caregiver = models.ForeignKey(Caregiver, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'patient'


class SideEffect(models.Model):
    id = models.BigIntegerField(primary_key=True)
    description = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'side_effect'


class Drug(models.Model):
    id = models.BigIntegerField(primary_key=True)
    dosage = models.BigIntegerField(blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'drug'


class DrugToSideEffects(models.Model):
    drug = models.ForeignKey(Drug, models.DO_NOTHING, primary_key=True)
    side_effect = models.ForeignKey(SideEffect, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'drug_to_side_effects'
        unique_together = (('drug', 'side_effect'),)


class HibernateSequence(models.Model):
    next_val = models.BigIntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'hibernate_sequence'


@python_2_unicode_compatible
class MedicationPlan(models.Model):
    id = models.BigIntegerField(primary_key=True)
    end_date = models.DateField(blank=True, null=True)
    intake_interval_period = models.IntegerField(blank=True, null=True)
    start_date = models.DateField(blank=True, null=True)
    doctor = models.ForeignKey(Doctor, models.DO_NOTHING, blank=True, null=True)
    patient = models.ForeignKey(Patient, models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'medication_plan'


@python_2_unicode_compatible
class MedicationPlanInterval(models.Model):
    id = models.BigIntegerField(primary_key=True)
    day = models.DateField(blank=True, null=True)
    hour = models.IntegerField(blank=True, null=True)
    intake_interval_end = models.IntegerField(blank=True, null=True)
    intake_interval_start = models.IntegerField(blank=True, null=True)
    taken_on_time = models.NullBooleanField()
    medication_plan = models.ForeignKey(MedicationPlan, models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'medication_plan_interval'


class MedicationPlanToDrugs(models.Model):
    medication_plan = models.ForeignKey(MedicationPlan, models.DO_NOTHING, primary_key=True)
    drug = models.ForeignKey(Drug, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'medication_plan_to_drugs'
        unique_together = (('medication_plan', 'drug'),)


