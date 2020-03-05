[![Build Status](https://travis-ci.com/AlexLRodrigues/dna_base_search.svg?branch=master)](https://travis-ci.com/AlexLRodrigues/dna_base_search)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=br.com%3Asimios&metric=alert_status)](https://sonarcloud.io/dashboard?id=br.com%3Asimios) 
[![SonarCloud Coverage](https://sonarcloud.io/api/project_badges/measure?project=br.com%3Asimios&metric=coverage)](https://sonarcloud.io/component_measures/metric/coverage/list?id=br.com%3Asimios)
[![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=br.com%3Asimios&metric=bugs)](https://sonarcloud.io/component_measures/metric/reliability_rating/list?id=br.com%3Asimios)
[![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=br.com%3Asimios&metric=vulnerabilities)](https://sonarcloud.io/component_measures/metric/security_rating/list?id=br.com%3Asimios)
# dna_base_search


#### Instruções para uso - Local
- Ter o Java 1.8 instalado na máquina;
- Importar o projeto em sua IDE de preferência;
- Executar o arquivo SimiosApplication.

Urls:

- POST - localhost:8080/simian

- GET - localhost:8080/stats


#### Instruções para uso - Cloud

Urls:

- POST - https://dna-base-search.appspot.com/simian

- GET - https://dna-base-search.appspot.com/stats


Payload Exemplo:

{
	"dna": ["ACTG", "ACTG", "ACTG", "ACTG"]
}