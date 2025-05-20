package forms

import forms.behaviours.BooleanFieldBehaviours
import play.api.data.FormError

class SantaExistsFormProviderSpec extends BooleanFieldBehaviours {

  val requiredKey = "antaExists.error.required"
  val invalidKey = "error.boolean"

  val form = new SantaExistsFormProvider()()

  ".value" - {

    val fieldName = "value"

    behave like booleanField(
      form,
      fieldName,
      invalidError = FormError(fieldName, invalidKey)
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
