<template>


    <v-card style="width:300px;" outlined>
        <v-card-title>
            Dog
        </v-card-title>

        <v-card-text>

        </v-card-text>

        <v-card-actions v-if="inList">
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="add"
                    v-else
            >
                Add
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

    import String from './primitives/String.vue';
    import Number from './primitives/Number.vue';
    import Boolean from './primitives/Boolean.vue';
    import Date from './primitives/Date.vue';

    

    export default {
        name: 'Dog',
        components:{
            String,
            Number,
            Boolean,
            Date,
            
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            
        }),
        created() {
            if(!this.value) {
                this.value = {};
            }
            if(typeof this.value === 'object') {
            }
        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

