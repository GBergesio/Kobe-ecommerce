package challenge.ecommerce.context;

import java.util.HashMap;
import java.util.Map;

public class AbstractEmailContext {
        private String from;
        private String to;
        private String subject;
        private String email;
        private String attachment;
        private String fromDisplayName;
        private String emailLanguage;
        private String displayName;
        private String templateLocation;
        private Map<String, Object> context;

        public AbstractEmailContext() {
            this.context = new HashMap<>();
        }

        public <T> void init(T context) {
            // we can do any common configuration setup here
            // like setting up some base URL and context
        }

        /**
         * @return the from
         */
        public String getFrom() {
            return from;
        }

        /**
         * @param from the from to set
         */
        public void setFrom(String from) {
            this.from = from;
        }

        /**
         * @return the to
         */
        public String getTo() {
            return to;
        }

        /**
         * @param to the to to set
         */
        public void setTo(String to) {
            this.to = to;
        }

        /**
         * @return the subject
         */
        public String getSubject() {
            return subject;
        }

        /**
         * @param subject the subject to set
         */
        public void setSubject(String subject) {
            this.subject = subject;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return the attachment
         */
        public String getAttachment() {
            return attachment;
        }

        /**
         * @param attachment the attachment to set
         */
        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        /**
         * @return the fromDisplayName
         */
        public String getFromDisplayName() {
            return fromDisplayName;
        }

        /**
         * @param fromDisplayName the fromDisplayName to set
         */
        public void setFromDisplayName(String fromDisplayName) {
            this.fromDisplayName = fromDisplayName;
        }

        /**
         * @return the emailLanguage
         */
        public String getEmailLanguage() {
            return emailLanguage;
        }

        /**
         * @param emailLanguage the emailLanguage to set
         */
        public void setEmailLanguage(String emailLanguage) {
            this.emailLanguage = emailLanguage;
        }

        /**
         * @return the displayName
         */
        public String getDisplayName() {
            return displayName;
        }

        /**
         * @param displayName the displayName to set
         */
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        /**
         * @return the templateLocation
         */
        public String getTemplateLocation() {
            return templateLocation;
        }

        /**
         * @param templateLocation the templateLocation to set
         */
        public void setTemplateLocation(String templateLocation) {
            this.templateLocation = templateLocation;
        }

        /**
         * @return the context
         */
        public Map<String, Object> getContext() {
            return context;
        }

        /**
         * @param context the context to set
         */
        public void setContext(Map<String, Object> context) {
            this.context = context;
        }

        public Object put(String key, Object value) {
            return key == null ? null : this.context.put(key.intern(), value);
        }
}
