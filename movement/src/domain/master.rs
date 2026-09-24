pub struct MasterTable {
    pub subject_name: Option<String>,
    pub subject_code: Option<String>,
    pub expected_classes: Option<u32>,
    pub frequency_per_week: Option<u32>,
}
impl MasterTable {
    pub fn new() -> Self {
        Self {
            subject_name: None,
            subject_code: None,
            expected_classes: None,
            frequency_per_week: None,
        }
    }
    pub fn with_name(mut self, name: String) -> Self {
        self.subject_name = Some(name);
        self
    }
}
