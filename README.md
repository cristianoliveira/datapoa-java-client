
# Datapoa Java Client Library
[![Build Status](https://travis-ci.org/CristianOliveiraDaRosa/datapoa-java-client.svg?branch=master)](https://travis-ci.org/CristianOliveiraDaRosa/datapoa-java-client)

The DataPoa Client Library for Java is a flexible, efficient, and powerful Open Source Java client library for accessing Porto Alegre's open data.

## About #DataPoa

The #DataPoa is a portal with open data from Porto Alegre, Brazil. It has the main goal to bring the community to use this data to create smart solutions for the city.

### About Data

This API has a lot of different kind of data like Mobility, Heath, Education and others.

DataPoa Portal http://datapoa.com.br/

DataPoa API http://datapoa.com.br/dataset

## Accessing API from Porto Alegre Open Data

To access data from DataPoa API with this library you will need use DataClient as below:

```

    DataResource dpResource = new DataResourceBuilder().resource(resourceId).build();

    DataEntity data = new DataClient(dpResource).doRequest();

    for (JsonObject record : data.getResult().getRecords()) {
        System.out.println(record.get(0));
    }

```
More details can be found on Unit Tests.

## Creating Customized Results

We made this library to be flexible. Then you can extend DataPoaEntity.class and implement your customized result. Using DataPoaClient:

```

    CustomizedResultEntity result = new DataClient(dpResource).doRequest(CustomizedResultEntity.class);

```
More details can be found on Unit Tests.

#Build and Run

The easiest way to build this library is with Gradle but you can pick your own way to do it.

```

     $ git clone https://github.com/DataPoa/datapoa-java-client.git
     $ cd datapoa-java-client
     $ gradle build

```

## Contributing

- **As User**

   1. Create New Features Issues
   2. Create Bug Issues

- **As Developer**

   1. Fork it!
   2. Create your feature branch: `git checkout -b my-new-feature`
   3. Commit your changes: `git commit -am 'Add some feature'`
   4. Push to the branch: `git push origin my-new-feature`
   5. Submit a pull request

**IMPORTANT**: Pull requests must have Unit Tests.

## License
This project is under MIT License.

### Authors / Contributors
Cristian Oliveira - (https://github.com/CristianOliveiraDaRosa)
