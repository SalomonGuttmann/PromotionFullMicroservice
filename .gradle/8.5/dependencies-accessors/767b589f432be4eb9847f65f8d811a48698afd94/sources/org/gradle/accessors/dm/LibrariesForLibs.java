package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComAppscampaignLibraryAccessors laccForComAppscampaignLibraryAccessors = new ComAppscampaignLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.appscampaign
         */
        public ComAppscampaignLibraryAccessors getAppscampaign() {
            return laccForComAppscampaignLibraryAccessors;
        }

    }

    public static class ComAppscampaignLibraryAccessors extends SubDependencyFactory {
        private final ComAppscampaignWsLibraryAccessors laccForComAppscampaignWsLibraryAccessors = new ComAppscampaignWsLibraryAccessors(owner);

        public ComAppscampaignLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.appscampaign.ws
         */
        public ComAppscampaignWsLibraryAccessors getWs() {
            return laccForComAppscampaignWsLibraryAccessors;
        }

    }

    public static class ComAppscampaignWsLibraryAccessors extends SubDependencyFactory {

        public ComAppscampaignWsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.appscampaign.ws:core)
         * with versionRef 'com.appscampaign.ws.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("com.appscampaign.ws.core");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);
        private final OrgSpringframeworkKafkaLibraryAccessors laccForOrgSpringframeworkKafkaLibraryAccessors = new OrgSpringframeworkKafkaLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.kafka
         */
        public OrgSpringframeworkKafkaLibraryAccessors getKafka() {
            return laccForOrgSpringframeworkKafkaLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (org.springframework.boot:spring-boot-starter-test)
         * with versionRef 'org.springframework.boot.spring.boot.starter.test'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("org.springframework.boot.spring.boot.starter.test");
        }

            /**
             * Creates a dependency provider for web (org.springframework.boot:spring-boot-starter-web)
         * with versionRef 'org.springframework.boot.spring.boot.starter.web'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWeb() {
                return create("org.springframework.boot.spring.boot.starter.web");
        }

    }

    public static class OrgSpringframeworkKafkaLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkKafkaSpringLibraryAccessors laccForOrgSpringframeworkKafkaSpringLibraryAccessors = new OrgSpringframeworkKafkaSpringLibraryAccessors(owner);

        public OrgSpringframeworkKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.kafka.spring
         */
        public OrgSpringframeworkKafkaSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkKafkaSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkKafkaSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkKafkaSpringKafkaLibraryAccessors laccForOrgSpringframeworkKafkaSpringKafkaLibraryAccessors = new OrgSpringframeworkKafkaSpringKafkaLibraryAccessors(owner);

        public OrgSpringframeworkKafkaSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.kafka.spring.kafka
         */
        public OrgSpringframeworkKafkaSpringKafkaLibraryAccessors getKafka() {
            return laccForOrgSpringframeworkKafkaSpringKafkaLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkKafkaSpringKafkaLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgSpringframeworkKafkaSpringKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kafka (org.springframework.kafka:spring-kafka)
         * with versionRef 'org.springframework.kafka.spring.kafka'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("org.springframework.kafka.spring.kafka");
        }

            /**
             * Creates a dependency provider for test (org.springframework.kafka:spring-kafka-test)
         * with versionRef 'org.springframework.kafka.spring.kafka.test'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("org.springframework.kafka.spring.kafka.test");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComAppscampaignVersionAccessors vaccForComAppscampaignVersionAccessors = new ComAppscampaignVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.appscampaign
         */
        public ComAppscampaignVersionAccessors getAppscampaign() {
            return vaccForComAppscampaignVersionAccessors;
        }

    }

    public static class ComAppscampaignVersionAccessors extends VersionFactory  {

        private final ComAppscampaignWsVersionAccessors vaccForComAppscampaignWsVersionAccessors = new ComAppscampaignWsVersionAccessors(providers, config);
        public ComAppscampaignVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.appscampaign.ws
         */
        public ComAppscampaignWsVersionAccessors getWs() {
            return vaccForComAppscampaignWsVersionAccessors;
        }

    }

    public static class ComAppscampaignWsVersionAccessors extends VersionFactory  {

        public ComAppscampaignWsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.appscampaign.ws.core (0.0.1-SNAPSHOT)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("com.appscampaign.ws.core"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        private final OrgSpringframeworkKafkaVersionAccessors vaccForOrgSpringframeworkKafkaVersionAccessors = new OrgSpringframeworkKafkaVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.kafka
         */
        public OrgSpringframeworkKafkaVersionAccessors getKafka() {
            return vaccForOrgSpringframeworkKafkaVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.test (3.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTest() { return getVersion("org.springframework.boot.spring.boot.starter.test"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.web (3.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

    }

    public static class OrgSpringframeworkKafkaVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkKafkaSpringVersionAccessors vaccForOrgSpringframeworkKafkaSpringVersionAccessors = new OrgSpringframeworkKafkaSpringVersionAccessors(providers, config);
        public OrgSpringframeworkKafkaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.kafka.spring
         */
        public OrgSpringframeworkKafkaSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkKafkaSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkKafkaSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkKafkaSpringKafkaVersionAccessors vaccForOrgSpringframeworkKafkaSpringKafkaVersionAccessors = new OrgSpringframeworkKafkaSpringKafkaVersionAccessors(providers, config);
        public OrgSpringframeworkKafkaSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.kafka.spring.kafka
         */
        public OrgSpringframeworkKafkaSpringKafkaVersionAccessors getKafka() {
            return vaccForOrgSpringframeworkKafkaSpringKafkaVersionAccessors;
        }

    }

    public static class OrgSpringframeworkKafkaSpringKafkaVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public OrgSpringframeworkKafkaSpringKafkaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: org.springframework.kafka.spring.kafka (3.1.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.springframework.kafka.spring.kafka"); }

            /**
             * Returns the version associated to this alias: org.springframework.kafka.spring.kafka.test (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTest() { return getVersion("org.springframework.kafka.spring.kafka.test"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
