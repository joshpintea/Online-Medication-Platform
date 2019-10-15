import React from 'react';
import Modal from "react-bootstrap/Modal";
import {sideEffectService} from "../../../service/sideeffect.service";


class BaseUpdateModel extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            show: false,
            toggleModal: props.toggleModal,
            callbackUpdateObject: props.callbackUpdateObject,
            obj: props.obj,
        };

        this.handleChange = this.handleChange.bind(this);
    }

    componentWillReceiveProps(nextProps) {
        this.setState({show: nextProps.show, obj: nextProps.obj});
    }

    getContentForm() {
        return (<div>
            Base
        </div>);
    }

    handleChange(e) {
        const {name, value} = e.target;
        const {obj} = this.state;
        let newObj = {};

        Object.assign(newObj, obj);
        newObj[name] = value;
        this.setState({obj: newObj});
    }

    render() {
        const {show, obj} = this.state;
        if (!show) {
            return (<div></div>)
        }

        const updateFormContent = this.getContentForm();
        return (
            <Modal show={show} onHide={this.props.toggleModal}>
                <Modal.Header closeButton>
                    <Modal.Title></Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {updateFormContent}
                </Modal.Body>
                <Modal.Footer>
                    <button className="btn secondary" onClick={this.props.toggleModal}>
                        Close
                    </button>
                </Modal.Footer>
            </Modal>
        )
    }
}

export {BaseUpdateModel}