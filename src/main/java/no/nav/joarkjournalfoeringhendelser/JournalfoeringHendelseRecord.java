/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package no.nav.joarkjournalfoeringhendelser;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class JournalfoeringHendelseRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    private static final long serialVersionUID = 5587546405910321381L;
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JournalfoeringHendelseRecord\",\"namespace\":\"no.nav.joarkjournalfoeringhendelser\",\"fields\":[{\"name\":\"hendelsesId\",\"type\":\"string\"},{\"name\":\"versjon\",\"type\":\"int\"},{\"name\":\"hendelsesType\",\"type\":\"string\"},{\"name\":\"journalpostId\",\"type\":\"long\"},{\"name\":\"journalpostStatus\",\"type\":\"string\"},{\"name\":\"temaGammelt\",\"type\":\"string\"},{\"name\":\"temaNytt\",\"type\":\"string\"},{\"name\":\"mottaksKanal\",\"type\":\"string\"},{\"name\":\"kanalReferanseId\",\"type\":\"string\"},{\"name\":\"behandlingstema\",\"type\":\"string\",\"default\":\"\"}]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    private static SpecificData MODEL$ = new SpecificData();

    private static final BinaryMessageEncoder<JournalfoeringHendelseRecord> ENCODER =
            new BinaryMessageEncoder<JournalfoeringHendelseRecord>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<JournalfoeringHendelseRecord> DECODER =
            new BinaryMessageDecoder<JournalfoeringHendelseRecord>(MODEL$, SCHEMA$);

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     */
    public static BinaryMessageDecoder<JournalfoeringHendelseRecord> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     */
    public static BinaryMessageDecoder<JournalfoeringHendelseRecord> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<JournalfoeringHendelseRecord>(MODEL$, SCHEMA$, resolver);
    }

    /** Serializes this JournalfoeringHendelseRecord to a ByteBuffer. */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    /** Deserializes a JournalfoeringHendelseRecord from a ByteBuffer. */
    public static JournalfoeringHendelseRecord fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    private java.lang.CharSequence hendelsesId;
    private int versjon;
    private java.lang.CharSequence hendelsesType;
    private long journalpostId;
    private java.lang.CharSequence journalpostStatus;
    private java.lang.CharSequence temaGammelt;
    private java.lang.CharSequence temaNytt;
    private java.lang.CharSequence mottaksKanal;
    private java.lang.CharSequence kanalReferanseId;
    private java.lang.CharSequence behandlingstema;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public JournalfoeringHendelseRecord() {
    }

    /**
     * All-args constructor.
     * @param hendelsesId The new value for hendelsesId
     * @param versjon The new value for versjon
     * @param hendelsesType The new value for hendelsesType
     * @param journalpostId The new value for journalpostId
     * @param journalpostStatus The new value for journalpostStatus
     * @param temaGammelt The new value for temaGammelt
     * @param temaNytt The new value for temaNytt
     * @param mottaksKanal The new value for mottaksKanal
     * @param kanalReferanseId The new value for kanalReferanseId
     * @param behandlingstema The new value for behandlingstema
     */
    public JournalfoeringHendelseRecord(java.lang.CharSequence hendelsesId, java.lang.Integer versjon, java.lang.CharSequence hendelsesType, java.lang.Long journalpostId, java.lang.CharSequence journalpostStatus, java.lang.CharSequence temaGammelt, java.lang.CharSequence temaNytt, java.lang.CharSequence mottaksKanal, java.lang.CharSequence kanalReferanseId, java.lang.CharSequence behandlingstema) {
        this.hendelsesId = hendelsesId;
        this.versjon = versjon;
        this.hendelsesType = hendelsesType;
        this.journalpostId = journalpostId;
        this.journalpostStatus = journalpostStatus;
        this.temaGammelt = temaGammelt;
        this.temaNytt = temaNytt;
        this.mottaksKanal = mottaksKanal;
        this.kanalReferanseId = kanalReferanseId;
        this.behandlingstema = behandlingstema;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0:
                return hendelsesId;
            case 1:
                return versjon;
            case 2:
                return hendelsesType;
            case 3:
                return journalpostId;
            case 4:
                return journalpostStatus;
            case 5:
                return temaGammelt;
            case 6:
                return temaNytt;
            case 7:
                return mottaksKanal;
            case 8:
                return kanalReferanseId;
            case 9:
                return behandlingstema;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                hendelsesId = (java.lang.CharSequence) value$;
                break;
            case 1:
                versjon = (java.lang.Integer) value$;
                break;
            case 2:
                hendelsesType = (java.lang.CharSequence) value$;
                break;
            case 3:
                journalpostId = (java.lang.Long) value$;
                break;
            case 4:
                journalpostStatus = (java.lang.CharSequence) value$;
                break;
            case 5:
                temaGammelt = (java.lang.CharSequence) value$;
                break;
            case 6:
                temaNytt = (java.lang.CharSequence) value$;
                break;
            case 7:
                mottaksKanal = (java.lang.CharSequence) value$;
                break;
            case 8:
                kanalReferanseId = (java.lang.CharSequence) value$;
                break;
            case 9:
                behandlingstema = (java.lang.CharSequence) value$;
                break;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'hendelsesId' field.
     * @return The value of the 'hendelsesId' field.
     */
    public java.lang.CharSequence getHendelsesId() {
        return hendelsesId;
    }


    /**
     * Gets the value of the 'versjon' field.
     * @return The value of the 'versjon' field.
     */
    public java.lang.Integer getVersjon() {
        return versjon;
    }


    /**
     * Gets the value of the 'hendelsesType' field.
     * @return The value of the 'hendelsesType' field.
     */
    public java.lang.CharSequence getHendelsesType() {
        return hendelsesType;
    }


    /**
     * Gets the value of the 'journalpostId' field.
     * @return The value of the 'journalpostId' field.
     */
    public java.lang.Long getJournalpostId() {
        return journalpostId;
    }


    /**
     * Gets the value of the 'journalpostStatus' field.
     * @return The value of the 'journalpostStatus' field.
     */
    public java.lang.CharSequence getJournalpostStatus() {
        return journalpostStatus;
    }


    /**
     * Gets the value of the 'temaGammelt' field.
     * @return The value of the 'temaGammelt' field.
     */
    public java.lang.CharSequence getTemaGammelt() {
        return temaGammelt;
    }


    /**
     * Gets the value of the 'temaNytt' field.
     * @return The value of the 'temaNytt' field.
     */
    public java.lang.CharSequence getTemaNytt() {
        return temaNytt;
    }


    /**
     * Gets the value of the 'mottaksKanal' field.
     * @return The value of the 'mottaksKanal' field.
     */
    public java.lang.CharSequence getMottaksKanal() {
        return mottaksKanal;
    }


    /**
     * Gets the value of the 'kanalReferanseId' field.
     * @return The value of the 'kanalReferanseId' field.
     */
    public java.lang.CharSequence getKanalReferanseId() {
        return kanalReferanseId;
    }


    /**
     * Gets the value of the 'behandlingstema' field.
     * @return The value of the 'behandlingstema' field.
     */
    public java.lang.CharSequence getBehandlingstema() {
        return behandlingstema;
    }


    /**
     * Creates a new JournalfoeringHendelseRecord RecordBuilder.
     * @return A new JournalfoeringHendelseRecord RecordBuilder
     */
    public static no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder newBuilder() {
        return new no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder();
    }

    /**
     * Creates a new JournalfoeringHendelseRecord RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new JournalfoeringHendelseRecord RecordBuilder
     */
    public static no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder newBuilder(no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder other) {
        return new no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder(other);
    }

    /**
     * Creates a new JournalfoeringHendelseRecord RecordBuilder by copying an existing JournalfoeringHendelseRecord instance.
     * @param other The existing instance to copy.
     * @return A new JournalfoeringHendelseRecord RecordBuilder
     */
    public static no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder newBuilder(no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord other) {
        return new no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder(other);
    }

    /**
     * RecordBuilder for JournalfoeringHendelseRecord instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JournalfoeringHendelseRecord>
            implements org.apache.avro.data.RecordBuilder<JournalfoeringHendelseRecord> {

        private java.lang.CharSequence hendelsesId;
        private int versjon;
        private java.lang.CharSequence hendelsesType;
        private long journalpostId;
        private java.lang.CharSequence journalpostStatus;
        private java.lang.CharSequence temaGammelt;
        private java.lang.CharSequence temaNytt;
        private java.lang.CharSequence mottaksKanal;
        private java.lang.CharSequence kanalReferanseId;
        private java.lang.CharSequence behandlingstema;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.hendelsesId)) {
                this.hendelsesId = data().deepCopy(fields()[0].schema(), other.hendelsesId);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.versjon)) {
                this.versjon = data().deepCopy(fields()[1].schema(), other.versjon);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.hendelsesType)) {
                this.hendelsesType = data().deepCopy(fields()[2].schema(), other.hendelsesType);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.journalpostId)) {
                this.journalpostId = data().deepCopy(fields()[3].schema(), other.journalpostId);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.journalpostStatus)) {
                this.journalpostStatus = data().deepCopy(fields()[4].schema(), other.journalpostStatus);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.temaGammelt)) {
                this.temaGammelt = data().deepCopy(fields()[5].schema(), other.temaGammelt);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.temaNytt)) {
                this.temaNytt = data().deepCopy(fields()[6].schema(), other.temaNytt);
                fieldSetFlags()[6] = true;
            }
            if (isValidValue(fields()[7], other.mottaksKanal)) {
                this.mottaksKanal = data().deepCopy(fields()[7].schema(), other.mottaksKanal);
                fieldSetFlags()[7] = true;
            }
            if (isValidValue(fields()[8], other.kanalReferanseId)) {
                this.kanalReferanseId = data().deepCopy(fields()[8].schema(), other.kanalReferanseId);
                fieldSetFlags()[8] = true;
            }
            if (isValidValue(fields()[9], other.behandlingstema)) {
                this.behandlingstema = data().deepCopy(fields()[9].schema(), other.behandlingstema);
                fieldSetFlags()[9] = true;
            }
        }

        /**
         * Creates a Builder by copying an existing JournalfoeringHendelseRecord instance
         * @param other The existing instance to copy.
         */
        private Builder(no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord other) {
            super(SCHEMA$);
            if (isValidValue(fields()[0], other.hendelsesId)) {
                this.hendelsesId = data().deepCopy(fields()[0].schema(), other.hendelsesId);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.versjon)) {
                this.versjon = data().deepCopy(fields()[1].schema(), other.versjon);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.hendelsesType)) {
                this.hendelsesType = data().deepCopy(fields()[2].schema(), other.hendelsesType);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.journalpostId)) {
                this.journalpostId = data().deepCopy(fields()[3].schema(), other.journalpostId);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.journalpostStatus)) {
                this.journalpostStatus = data().deepCopy(fields()[4].schema(), other.journalpostStatus);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.temaGammelt)) {
                this.temaGammelt = data().deepCopy(fields()[5].schema(), other.temaGammelt);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.temaNytt)) {
                this.temaNytt = data().deepCopy(fields()[6].schema(), other.temaNytt);
                fieldSetFlags()[6] = true;
            }
            if (isValidValue(fields()[7], other.mottaksKanal)) {
                this.mottaksKanal = data().deepCopy(fields()[7].schema(), other.mottaksKanal);
                fieldSetFlags()[7] = true;
            }
            if (isValidValue(fields()[8], other.kanalReferanseId)) {
                this.kanalReferanseId = data().deepCopy(fields()[8].schema(), other.kanalReferanseId);
                fieldSetFlags()[8] = true;
            }
            if (isValidValue(fields()[9], other.behandlingstema)) {
                this.behandlingstema = data().deepCopy(fields()[9].schema(), other.behandlingstema);
                fieldSetFlags()[9] = true;
            }
        }

        /**
         * Gets the value of the 'hendelsesId' field.
         * @return The value.
         */
        public java.lang.CharSequence getHendelsesId() {
            return hendelsesId;
        }

        /**
         * Sets the value of the 'hendelsesId' field.
         * @param value The value of 'hendelsesId'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setHendelsesId(java.lang.CharSequence value) {
            validate(fields()[0], value);
            this.hendelsesId = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'hendelsesId' field has been set.
         * @return True if the 'hendelsesId' field has been set, false otherwise.
         */
        public boolean hasHendelsesId() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'hendelsesId' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearHendelsesId() {
            hendelsesId = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'versjon' field.
         * @return The value.
         */
        public java.lang.Integer getVersjon() {
            return versjon;
        }

        /**
         * Sets the value of the 'versjon' field.
         * @param value The value of 'versjon'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setVersjon(int value) {
            validate(fields()[1], value);
            this.versjon = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'versjon' field has been set.
         * @return True if the 'versjon' field has been set, false otherwise.
         */
        public boolean hasVersjon() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'versjon' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearVersjon() {
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'hendelsesType' field.
         * @return The value.
         */
        public java.lang.CharSequence getHendelsesType() {
            return hendelsesType;
        }

        /**
         * Sets the value of the 'hendelsesType' field.
         * @param value The value of 'hendelsesType'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setHendelsesType(java.lang.CharSequence value) {
            validate(fields()[2], value);
            this.hendelsesType = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'hendelsesType' field has been set.
         * @return True if the 'hendelsesType' field has been set, false otherwise.
         */
        public boolean hasHendelsesType() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'hendelsesType' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearHendelsesType() {
            hendelsesType = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'journalpostId' field.
         * @return The value.
         */
        public java.lang.Long getJournalpostId() {
            return journalpostId;
        }

        /**
         * Sets the value of the 'journalpostId' field.
         * @param value The value of 'journalpostId'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setJournalpostId(long value) {
            validate(fields()[3], value);
            this.journalpostId = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'journalpostId' field has been set.
         * @return True if the 'journalpostId' field has been set, false otherwise.
         */
        public boolean hasJournalpostId() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'journalpostId' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearJournalpostId() {
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'journalpostStatus' field.
         * @return The value.
         */
        public java.lang.CharSequence getJournalpostStatus() {
            return journalpostStatus;
        }

        /**
         * Sets the value of the 'journalpostStatus' field.
         * @param value The value of 'journalpostStatus'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setJournalpostStatus(java.lang.CharSequence value) {
            validate(fields()[4], value);
            this.journalpostStatus = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'journalpostStatus' field has been set.
         * @return True if the 'journalpostStatus' field has been set, false otherwise.
         */
        public boolean hasJournalpostStatus() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'journalpostStatus' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearJournalpostStatus() {
            journalpostStatus = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'temaGammelt' field.
         * @return The value.
         */
        public java.lang.CharSequence getTemaGammelt() {
            return temaGammelt;
        }

        /**
         * Sets the value of the 'temaGammelt' field.
         * @param value The value of 'temaGammelt'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setTemaGammelt(java.lang.CharSequence value) {
            validate(fields()[5], value);
            this.temaGammelt = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'temaGammelt' field has been set.
         * @return True if the 'temaGammelt' field has been set, false otherwise.
         */
        public boolean hasTemaGammelt() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'temaGammelt' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearTemaGammelt() {
            temaGammelt = null;
            fieldSetFlags()[5] = false;
            return this;
        }

        /**
         * Gets the value of the 'temaNytt' field.
         * @return The value.
         */
        public java.lang.CharSequence getTemaNytt() {
            return temaNytt;
        }

        /**
         * Sets the value of the 'temaNytt' field.
         * @param value The value of 'temaNytt'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setTemaNytt(java.lang.CharSequence value) {
            validate(fields()[6], value);
            this.temaNytt = value;
            fieldSetFlags()[6] = true;
            return this;
        }

        /**
         * Checks whether the 'temaNytt' field has been set.
         * @return True if the 'temaNytt' field has been set, false otherwise.
         */
        public boolean hasTemaNytt() {
            return fieldSetFlags()[6];
        }


        /**
         * Clears the value of the 'temaNytt' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearTemaNytt() {
            temaNytt = null;
            fieldSetFlags()[6] = false;
            return this;
        }

        /**
         * Gets the value of the 'mottaksKanal' field.
         * @return The value.
         */
        public java.lang.CharSequence getMottaksKanal() {
            return mottaksKanal;
        }

        /**
         * Sets the value of the 'mottaksKanal' field.
         * @param value The value of 'mottaksKanal'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setMottaksKanal(java.lang.CharSequence value) {
            validate(fields()[7], value);
            this.mottaksKanal = value;
            fieldSetFlags()[7] = true;
            return this;
        }

        /**
         * Checks whether the 'mottaksKanal' field has been set.
         * @return True if the 'mottaksKanal' field has been set, false otherwise.
         */
        public boolean hasMottaksKanal() {
            return fieldSetFlags()[7];
        }


        /**
         * Clears the value of the 'mottaksKanal' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearMottaksKanal() {
            mottaksKanal = null;
            fieldSetFlags()[7] = false;
            return this;
        }

        /**
         * Gets the value of the 'kanalReferanseId' field.
         * @return The value.
         */
        public java.lang.CharSequence getKanalReferanseId() {
            return kanalReferanseId;
        }

        /**
         * Sets the value of the 'kanalReferanseId' field.
         * @param value The value of 'kanalReferanseId'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setKanalReferanseId(java.lang.CharSequence value) {
            validate(fields()[8], value);
            this.kanalReferanseId = value;
            fieldSetFlags()[8] = true;
            return this;
        }

        /**
         * Checks whether the 'kanalReferanseId' field has been set.
         * @return True if the 'kanalReferanseId' field has been set, false otherwise.
         */
        public boolean hasKanalReferanseId() {
            return fieldSetFlags()[8];
        }


        /**
         * Clears the value of the 'kanalReferanseId' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearKanalReferanseId() {
            kanalReferanseId = null;
            fieldSetFlags()[8] = false;
            return this;
        }

        /**
         * Gets the value of the 'behandlingstema' field.
         * @return The value.
         */
        public java.lang.CharSequence getBehandlingstema() {
            return behandlingstema;
        }

        /**
         * Sets the value of the 'behandlingstema' field.
         * @param value The value of 'behandlingstema'.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder setBehandlingstema(java.lang.CharSequence value) {
            validate(fields()[9], value);
            this.behandlingstema = value;
            fieldSetFlags()[9] = true;
            return this;
        }

        /**
         * Checks whether the 'behandlingstema' field has been set.
         * @return True if the 'behandlingstema' field has been set, false otherwise.
         */
        public boolean hasBehandlingstema() {
            return fieldSetFlags()[9];
        }


        /**
         * Clears the value of the 'behandlingstema' field.
         * @return This builder.
         */
        public no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord.Builder clearBehandlingstema() {
            behandlingstema = null;
            fieldSetFlags()[9] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public JournalfoeringHendelseRecord build() {
            try {
                JournalfoeringHendelseRecord record = new JournalfoeringHendelseRecord();
                record.hendelsesId = fieldSetFlags()[0] ? this.hendelsesId : (java.lang.CharSequence) defaultValue(fields()[0]);
                record.versjon = fieldSetFlags()[1] ? this.versjon : (java.lang.Integer) defaultValue(fields()[1]);
                record.hendelsesType = fieldSetFlags()[2] ? this.hendelsesType : (java.lang.CharSequence) defaultValue(fields()[2]);
                record.journalpostId = fieldSetFlags()[3] ? this.journalpostId : (java.lang.Long) defaultValue(fields()[3]);
                record.journalpostStatus = fieldSetFlags()[4] ? this.journalpostStatus : (java.lang.CharSequence) defaultValue(fields()[4]);
                record.temaGammelt = fieldSetFlags()[5] ? this.temaGammelt : (java.lang.CharSequence) defaultValue(fields()[5]);
                record.temaNytt = fieldSetFlags()[6] ? this.temaNytt : (java.lang.CharSequence) defaultValue(fields()[6]);
                record.mottaksKanal = fieldSetFlags()[7] ? this.mottaksKanal : (java.lang.CharSequence) defaultValue(fields()[7]);
                record.kanalReferanseId = fieldSetFlags()[8] ? this.kanalReferanseId : (java.lang.CharSequence) defaultValue(fields()[8]);
                record.behandlingstema = fieldSetFlags()[9] ? this.behandlingstema : (java.lang.CharSequence) defaultValue(fields()[9]);
                return record;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<JournalfoeringHendelseRecord>
            WRITER$ = (org.apache.avro.io.DatumWriter<JournalfoeringHendelseRecord>) MODEL$.createDatumWriter(SCHEMA$);

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<JournalfoeringHendelseRecord>
            READER$ = (org.apache.avro.io.DatumReader<JournalfoeringHendelseRecord>) MODEL$.createDatumReader(SCHEMA$);

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

}