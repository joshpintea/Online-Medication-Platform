import React from 'react';
import ReactApexChart from 'react-apexcharts';

class ActivityBarChart extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            activities: []
        }
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({activities: nextProps.activities});
    }

    minDate(activities) {
        var minDt = activities[0].start;

        activities.forEach(function(activity, index) {
            if (activity.start < minDt) {
                minDt = activity.start;
            }
        });
        return minDt;
    }

    maxDate(activities) {
        var maxDt = activities[0].end;

        activities.forEach(function(activity, index) {
            if (activity.end > maxDt) {
                maxDt = activity.end;
            }
        });
        return maxDt;
    }

    render() {
        const {activities} = this.state;
        console.log(activities)
        if (activities.length == 0) {
            return (
                <div></div>
            )

        }

        const activitiesProcess = activities.map( (activity) => {
                return {
                    id: activity.id,
                    label: activity.activityLabel,
                    start: new Date(activity.start),
                    end: new Date(activity.end)
                }
        });


        const minDate = this.minDate(activitiesProcess);
        const maxDate = this.maxDate(activitiesProcess);


        const data = activitiesProcess.map((activity) => {
            return {
                x: activity.label,
                y: [activity.start.getTime(), activity.end.getTime()]
            }
        });

        console.log(maxDate, minDate);
        var state = {
            options: {
                plotOptions: {
                    bar: {
                        horizontal: true,
                    }
                },
                yaxis: {
                    min: minDate.getTime(),
                    max: maxDate.getTime()
                },
                xaxis: {
                    type: 'datetime'
                },
                fill: {
                    type: 'gradient',
                    gradient: {
                        shade: 'light',
                        type: "vertical",
                        shadeIntensity: 0.25,
                        gradientToColors: undefined,
                        inverseColors: true,
                        opacityFrom: 1,
                        opacityTo: 1,
                        stops: [50, 0, 100, 100]
                    }
                }
            },
            series: [
                {
                    name: 'Activities',
                    data: data
                }
                // {
                //     name: 'Bob',
                //     data: [{
                //         x: 'Design',
                //         y: [new Date('2019-03-02').getTime(), new Date('2019-03-03').getTime()]
                //     }, {
                //         x: 'Code',
                //         y: [new Date('2019-03-02').getTime(), new Date('2019-03-04').getTime()]
                //
                //     }, {
                //         x: 'Test',
                //         y: [new Date('2019-03-04').getTime(), new Date('2019-03-07').getTime()]
                //     }, {
                //         x: 'Deployment',
                //         y: [new Date('2019-03-11').getTime(), new Date('2019-03-12').getTime()]
                //     }]
                // }, {
                //     name: 'Joe',
                //     data: [{
                //         x: 'Design',
                //         y: [new Date('2019-03-01').getTime(), new Date('2019-03-02').getTime()]
                //     }, {
                //         x: 'Code',
                //         y: [new Date('2019-03-03').getTime(), new Date('2019-03-07').getTime()]
                //     }, {
                //         x: 'Test',
                //         y: [new Date('2019-03-06').getTime(), new Date('2019-03-09').getTime()]
                //     }, {
                //         x: 'Deployment',
                //         y: [new Date('2019-03-10').getTime(), new Date('2019-03-11').getTime()]
                //     }]
                // }
            ],
        };

        return (
            <div id="chart">
                <ReactApexChart options={state.options} series={state.series} type="rangeBar" height="350" />
            </div>
        )

    }
}

export {ActivityBarChart};