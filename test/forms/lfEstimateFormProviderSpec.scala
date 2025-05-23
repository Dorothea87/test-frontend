package forms

import forms.behaviours.IntFieldBehaviours
import play.api.data.FormError

class lfEstimateFormProviderSpec extends IntFieldBehaviours {

  val form = new lfEstimateFormProvider()()

  ".value" - {

    val fieldName = "value"

    val minimum = 1
    val maximum = 5000

    val validDataGenerator = intsInRangeWithCommas(minimum, maximum)

    behave like fieldThatBindsValidData(
      form,
      fieldName,
      validDataGenerator
    )

    behave like intField(
      form,
      fieldName,
      nonNumericError  = FormError(fieldName, "lfEstimate.error.nonNumeric"),
      wholeNumberError = FormError(fieldName, "lfEstimate.error.wholeNumber")
    )

    behave like intFieldWithRange(
      form,
      fieldName,
      minimum       = minimum,
      maximum       = maximum,
      expectedError = FormError(fieldName, "lfEstimate.error.outOfRange", Seq(minimum, maximum))
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, "lfEstimate.error.required")
    )
  }
}
