import React from 'react';
import {MDBIcon} from "mdbreact";

class ModelCrudComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            modelName: props.modelName,
            CreateComponent: props.CreateComponent,
            UpdateComponent: props.UpdateComponent,
            objects: [],
            columns: props.columns,
            service: props.service,
            showUpdateModal: false,
            objSelectedForUpdate: {}
        };

        this.createListingContent = this.createListingContent.bind(this);
        this.deleteObject = this.deleteObject.bind(this);
        this.callbackNewObject = this.callbackNewObject.bind(this);
        this.toggleModal = this.toggleModal.bind(this);
        this.changeSelectedObject = this.changeSelectedObject.bind(this);
        this.callbackUpdateObject = this.callbackUpdateObject.bind(this);
    }

    componentDidMount() {
        this.state.service.getAll().then(
            obj => {
                this.setState({objects: obj});
            }
        )
    }


    deleteObject(objectId) {
        const {objects, service} = this.state;

        service.deleteObj(objectId).then(
            success => {
                let objectsAfter = objects.reduce(function (res, obj) {
                    if (obj.id !== objectId) {
                        res.push(obj);
                    }

                    return res;
                }, []);

                this.setState({objects: objectsAfter})
            }
        )

    }

    callbackNewObject(obj) {
        const {objects} = this.state;

        let newObjects = objects.map( (obj) => obj);
        newObjects.push(obj);

        this.setState({objects:newObjects})
    }

    callbackUpdateObject(obj) {
        const {objects} = this.state;

        let updatedListOfObjects = objects.map( (objModel) => {
            if (objModel.id !== obj.id) {
                return objModel;
            }

            return obj;
        });

        this.setState({objects: updatedListOfObjects, showUpdateModal: false});
    }

    toggleModal() {
        const {showUpdateModal} = this.state;

        this.setState({showUpdateModal: !showUpdateModal});
    }

    changeSelectedObject(obj) {
        this.setState({objSelectedForUpdate: obj, showUpdateModal: true});
    }

    createListingContent() {
        const {columns, objects} = this.state;

        let tableColumns = columns.map ( (column) => {
            return (
                <th scope={"col"}>{column}</th>
            )
        });

        let tableColumnsFunc = () => {
            return (
                <tr>
                    {tableColumns}
                    <th scope={"col"}>Actions</th>
                </tr>
            )
        };

        let tableData = objects.map ( (objectModel) => {
            let dataColumns = columns.map( (column) => {
                return (
                    <td>
                        {objectModel[column]}
                    </td>
                )
            });

            return (
                <tr>
                    {dataColumns}
                    <td>
                        <button onClick={() => this.changeSelectedObject(objectModel)}><MDBIcon icon="pencil" fixed /> </button>
                        <button onClick={() => this.deleteObject(objectModel.id)}><MDBIcon icon="trash-o" fixed /> </button>
                    </td>
                </tr>
            )
        });

        return (
            <table className={"table"}>
                <thead>
                    {tableColumnsFunc()}
                </thead>
                <tbody>
                    {tableData}
                </tbody>
            </table>
        )
    }


    render() {
        const {modelName,objSelectedForUpdate, showUpdateModal, CreateComponent, UpdateComponent} = this.state;

        const listingContent = this.createListingContent();
        return (
            <div className={"jumbotron"}>
                <h1>{modelName}</h1>
                <br/>
                <div className={"row"}>
                    <div className={"col-md-8"}>
                        <h2>Listing</h2>
                        {listingContent}
                    </div>

                    <div className={"col-md-4"}>
                        <h2>Create</h2>
                        <CreateComponent callbackNewObject={this.callbackNewObject}/>
                    </div>
                </div>

                <UpdateComponent show={showUpdateModal} toggleModal={this.toggleModal} obj={objSelectedForUpdate}
                                 callbackUpdateObject={this.callbackUpdateObject}/>
            </div>
        )
    }
}

export {ModelCrudComponent}