// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: person_java_interop_kotlin.proto
package com.squareup.wire.protos.person.javainteropkotlin

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireEnum
import com.squareup.wire.WireField
import com.squareup.wire.internal.checkElementsNotNull
import com.squareup.wire.internal.missingRequiredFields
import com.squareup.wire.internal.redactElements
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.hashCode
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import okio.ByteString

/**
 * Message representing a person, includes their name, unique ID number, email and phone number.
 */
class Person(
  /**
   * The customer's full name.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REQUIRED
  )
  @JvmField
  val name: String,
  /**
   * The customer's ID number.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#INT32",
    label = WireField.Label.REQUIRED
  )
  @JvmField
  val id: Int,
  /**
   * Email address for the customer.
   */
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @JvmField
  val email: String? = null,
  /**
   * A list of the customer's phone numbers.
   */
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.protos.person.javainteropkotlin.Person${'$'}PhoneNumber#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val phone: List<PhoneNumber> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Person, Person.Builder>(ADAPTER, unknownFields) {
  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.name = name
    builder.id = id
    builder.email = email
    builder.phone = phone
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Person) return false
    return unknownFields == other.unknownFields
        && name == other.name
        && id == other.id
        && email == other.email
        && phone == other.phone
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + name.hashCode()
      result = result * 37 + id.hashCode()
      result = result * 37 + email.hashCode()
      result = result * 37 + phone.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """name=$name"""
    result += """id=$id"""
    if (email != null) result += """email=$email"""
    if (phone.isNotEmpty()) result += """phone=$phone"""
    return result.joinToString(prefix = "Person{", separator = ", ", postfix = "}")
  }

  fun copy(
    name: String = this.name,
    id: Int = this.id,
    email: String? = this.email,
    phone: List<PhoneNumber> = this.phone,
    unknownFields: ByteString = this.unknownFields
  ): Person = Person(name, id, email, phone, unknownFields)

  class Builder : Message.Builder<Person, Builder>() {
    @JvmField
    var name: String? = null

    @JvmField
    var id: Int? = null

    @JvmField
    var email: String? = null

    @JvmField
    var phone: List<PhoneNumber> = emptyList()

    /**
     * The customer's full name.
     */
    fun name(name: String): Builder {
      this.name = name
      return this
    }

    /**
     * The customer's ID number.
     */
    fun id(id: Int): Builder {
      this.id = id
      return this
    }

    /**
     * Email address for the customer.
     */
    fun email(email: String?): Builder {
      this.email = email
      return this
    }

    /**
     * A list of the customer's phone numbers.
     */
    fun phone(phone: List<PhoneNumber>): Builder {
      checkElementsNotNull(phone)
      this.phone = phone
      return this
    }

    override fun build(): Person = Person(
      name = name ?: throw missingRequiredFields(name, "name"),
      id = id ?: throw missingRequiredFields(id, "id"),
      email = email,
      phone = phone,
      unknownFields = buildUnknownFields()
    )
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Person> = object : ProtoAdapter<Person>(
      FieldEncoding.LENGTH_DELIMITED, 
      Person::class
    ) {
      override fun encodedSize(value: Person): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        ProtoAdapter.INT32.encodedSizeWithTag(2, value.id) +
        ProtoAdapter.STRING.encodedSizeWithTag(3, value.email) +
        PhoneNumber.ADAPTER.asRepeated().encodedSizeWithTag(4, value.phone) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: Person) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        ProtoAdapter.INT32.encodeWithTag(writer, 2, value.id)
        ProtoAdapter.STRING.encodeWithTag(writer, 3, value.email)
        PhoneNumber.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.phone)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Person {
        var name: String? = null
        var id: Int? = null
        var email: String? = null
        val phone = mutableListOf<PhoneNumber>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> id = ProtoAdapter.INT32.decode(reader)
            3 -> email = ProtoAdapter.STRING.decode(reader)
            4 -> phone.add(PhoneNumber.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return Person(
          name = name ?: throw missingRequiredFields(name, "name"),
          id = id ?: throw missingRequiredFields(id, "id"),
          email = email,
          phone = phone,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Person): Person = value.copy(
        phone = value.phone.redactElements(PhoneNumber.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }

  /**
   * Represents the type of the phone number: mobile, home or work.
   */
  enum class PhoneType(
    override val value: Int
  ) : WireEnum {
    MOBILE(0),

    HOME(1),

    /**
     * Could be phone or fax.
     */
    WORK(2);

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<PhoneType> = object : EnumAdapter<PhoneType>(
        PhoneType::class
      ) {
        override fun fromValue(value: Int): PhoneType? = PhoneType.fromValue(value)
      }

      @JvmStatic
      fun fromValue(value: Int): PhoneType? = when (value) {
        0 -> MOBILE
        1 -> HOME
        2 -> WORK
        else -> null
      }
    }
  }

  class PhoneNumber(
    /**
     * The customer's phone number.
     */
    @field:WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
    )
    @JvmField
    val number: String,
    /**
     * The type of phone stored here.
     */
    @field:WireField(
      tag = 2,
      adapter = "com.squareup.wire.protos.person.javainteropkotlin.Person${'$'}PhoneType#ADAPTER"
    )
    @JvmField
    val type: PhoneType? = null,
    unknownFields: ByteString = ByteString.EMPTY
  ) : Message<PhoneNumber, PhoneNumber.Builder>(ADAPTER, unknownFields) {
    override fun newBuilder(): Builder {
      val builder = Builder()
      builder.number = number
      builder.type = type
      builder.addUnknownFields(unknownFields)
      return builder
    }

    override fun equals(other: Any?): Boolean {
      if (other === this) return true
      if (other !is PhoneNumber) return false
      return unknownFields == other.unknownFields
          && number == other.number
          && type == other.type
    }

    override fun hashCode(): Int {
      var result = super.hashCode
      if (result == 0) {
        result = unknownFields.hashCode()
        result = result * 37 + number.hashCode()
        result = result * 37 + type.hashCode()
        super.hashCode = result
      }
      return result
    }

    override fun toString(): String {
      val result = mutableListOf<String>()
      result += """number=$number"""
      if (type != null) result += """type=$type"""
      return result.joinToString(prefix = "PhoneNumber{", separator = ", ", postfix = "}")
    }

    fun copy(
      number: String = this.number,
      type: PhoneType? = this.type,
      unknownFields: ByteString = this.unknownFields
    ): PhoneNumber = PhoneNumber(number, type, unknownFields)

    class Builder : Message.Builder<PhoneNumber, Builder>() {
      @JvmField
      var number: String? = null

      @JvmField
      var type: PhoneType? = null

      /**
       * The customer's phone number.
       */
      fun number(number: String): Builder {
        this.number = number
        return this
      }

      /**
       * The type of phone stored here.
       */
      fun type(type: PhoneType?): Builder {
        this.type = type
        return this
      }

      override fun build(): PhoneNumber = PhoneNumber(
        number = number ?: throw missingRequiredFields(number, "number"),
        type = type,
        unknownFields = buildUnknownFields()
      )
    }

    companion object {
      @JvmField
      val DEFAULT_TYPE: PhoneType = PhoneType.HOME

      @JvmField
      val ADAPTER: ProtoAdapter<PhoneNumber> = object : ProtoAdapter<PhoneNumber>(
        FieldEncoding.LENGTH_DELIMITED, 
        PhoneNumber::class
      ) {
        override fun encodedSize(value: PhoneNumber): Int = 
          ProtoAdapter.STRING.encodedSizeWithTag(1, value.number) +
          PhoneType.ADAPTER.encodedSizeWithTag(2, value.type) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: PhoneNumber) {
          ProtoAdapter.STRING.encodeWithTag(writer, 1, value.number)
          PhoneType.ADAPTER.encodeWithTag(writer, 2, value.type)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): PhoneNumber {
          var number: String? = null
          var type: PhoneType? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> number = ProtoAdapter.STRING.decode(reader)
              2 -> type = PhoneType.ADAPTER.decode(reader)
              else -> reader.readUnknownField(tag)
            }
          }
          return PhoneNumber(
            number = number ?: throw missingRequiredFields(number, "number"),
            type = type,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: PhoneNumber): PhoneNumber = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
